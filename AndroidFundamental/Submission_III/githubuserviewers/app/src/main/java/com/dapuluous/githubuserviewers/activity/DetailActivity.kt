package com.dapuluous.githubuserviewers.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.widget.ViewPager2
import com.bumptech.glide.Glide
import com.dapuluous.githubuserviewers.R
import com.dapuluous.githubuserviewers.adapter.SectionPagerAdapter
import com.dapuluous.githubuserviewers.controller.DetailViewModel
import com.dapuluous.githubuserviewers.controller.ViewModelFactory
import com.dapuluous.githubuserviewers.databinding.ActivityDetailBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val model = obtainViewModel(this@DetailActivity)
        val username = intent.getStringExtra(EXTRA_USER)
        val id = intent.getIntExtra(EXTRA_ID, 0)
        val avatarUrl = intent.getStringExtra((EXTRA_AVATAR_URL))

        val bundle = Bundle()
        bundle.putString(EXTRA_USER, username)

        val sectionsPagerAdapter = SectionPagerAdapter(this, bundle)
        val viewPager: ViewPager2 = findViewById(R.id.view_pager)

        if (username != null) {
            model.setUserDetail(username)
        }

        model.getUserDetail().observe(this, {
            if (it != null) {
                supportActionBar?.title = "${it.login}'s Profile"

                val tab1 = "${it.followers} Followers"
                val tab2 = "${it.following} Following"

                val TAB_TITLES = arrayListOf(
                    tab1,
                    tab2
                )

                viewPager.adapter = sectionsPagerAdapter
                val tabs: TabLayout = findViewById(R.id.tabs)
                TabLayoutMediator(tabs, viewPager) { tab, position ->
                    tab.text = TAB_TITLES[position]
                }.attach()

                binding.apply {
                    Glide.with(this@DetailActivity)
                        .load(it.avatarUrl)
                        .into(profilePhoto)
                    usernameShare = it.login
                    profileUsername.text = it.login
                    profileName.text = if(it.name != null) it.name else "Name Not Set"
                    profileCompany.text = if(it.company != null) "Works in in ${it.company}" else "Company Not Set"
                    profileLocation.text = if(it.location != null) "Lives in ${it.location}" else "Location Not Set"
                }
            }
        })

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        var checked = false

        CoroutineScope(Dispatchers.IO).launch {
            val count = model.checkUser(id)
            withContext(Dispatchers.Main) {
                if (count > 0) {
                    binding.toggleFavorite.isSelected = true
                    checked = true
                } else {
                    binding.toggleFavorite.isSelected = false
                    checked = false
                }
            }
        }

        binding.toggleFavorite.setOnClickListener {
            checked = !checked
            if (checked) {
                if (username != null) {
                    if (avatarUrl != null) { model.addFavorite(username, id, avatarUrl) }
                }
            } else {
                model.deleteFavorite(id)
            }
            binding.toggleFavorite.isSelected = checked
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }

    private fun setMode(selectedMode: Int) {
        when (selectedMode) {
            R.id.share -> {
                val shareIntent = Intent()
                shareIntent.action = Intent.ACTION_SEND
                shareIntent.type = "text/plain"
                shareIntent.putExtra(Intent.EXTRA_TEXT, "https://github.com/$usernameShare")
                startActivity(Intent.createChooser(shareIntent, "Share via"))
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_fav, menu)
        return super.onCreateOptionsMenu(menu)
    }

    private fun obtainViewModel(activity: AppCompatActivity): DetailViewModel {
        val factory = ViewModelFactory.getInstance(activity.application)
        return ViewModelProvider(activity, factory).get(DetailViewModel::class.java)
    }

    companion object {
        const val EXTRA_USER = "extra_user"
        const val EXTRA_ID = "extra_id"
        const val EXTRA_AVATAR_URL = "extra_avatar_url"

        var usernameShare = ""
    }
}

private operator fun Unit.compareTo(i: Int): Int {
    return i
}
