package com.dapuluous.githubuserviewers.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.dapuluous.githubuserviewers.adapter.UserAdapter
import com.dapuluous.githubuserviewers.controller.FavoriteViewModel
import com.dapuluous.githubuserviewers.controller.ViewModelFactory
import com.dapuluous.githubuserviewers.database.FavoriteUser
import com.dapuluous.githubuserviewers.databinding.ActivityFavoriteBinding
import com.dapuluous.githubuserviewers.model.ItemsItem

class FavoriteActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFavoriteBinding
    private val title: String = "Favorite Users"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFavoriteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = title
        val model = obtainViewModel(this@FavoriteActivity)

        val layoutManager = LinearLayoutManager(this)
        binding.rvUsers.layoutManager = layoutManager
        val itemDecoration = DividerItemDecoration(this, layoutManager.orientation)
        binding.rvUsers.addItemDecoration(itemDecoration)
        val adapter = UserAdapter()
        adapter.notifyDataSetChanged()
        binding.rvUsers.adapter = adapter

        adapter.setOnItemClickCallback(object : UserAdapter.OnItemClickCallback {
            override fun onItemClicked(data: ItemsItem) {
                Intent(this@FavoriteActivity, DetailActivity::class.java).also {
                    it.putExtra(DetailActivity.EXTRA_USER, data.login)
                    it.putExtra(DetailActivity.EXTRA_ID, data.id)
                    it.putExtra(DetailActivity.EXTRA_AVATAR_URL, data.avatarUrl)
                    startActivity(it)
                }
            }
        })

        model.getAllFavoriteUser().observe(this, {
            if (it != null) {
                val list = mapList(it)
                adapter.setList(list)
            }
        })
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    private fun mapList(users: List<FavoriteUser>): ArrayList<ItemsItem> {
        val listUsers = ArrayList<ItemsItem>()
        for (user in users) {
            val userMapped = ItemsItem(
                user.avatar_url,
                user.id,
                user.login
            )
            listUsers.add(userMapped)
        }
        return listUsers
    }

    private fun obtainViewModel(activity: AppCompatActivity): FavoriteViewModel {
        val factory = ViewModelFactory.getInstance(activity.application)
        return ViewModelProvider(activity, factory).get(FavoriteViewModel::class.java)
    }
}