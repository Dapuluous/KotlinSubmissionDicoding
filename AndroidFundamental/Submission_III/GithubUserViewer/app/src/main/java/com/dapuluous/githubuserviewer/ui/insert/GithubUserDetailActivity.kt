package com.dapuluous.githubuserviewer.ui.insert

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.viewpager2.widget.ViewPager2
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.dapuluous.githubuserviewer.R
import com.dapuluous.githubuserviewer.adapters.SectionsPagerAdapter
import com.dapuluous.githubuserviewer.databinding.ActivityGithubUserDetailBinding
import com.dapuluous.githubuserviewer.model.GithubUser
import com.dapuluous.githubuserviewer.model.GithubUserFav
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_github_user_detail.*
import kotlinx.android.synthetic.main.item_favs.*

class GithubUserDetailActivity : AppCompatActivity(), View.OnClickListener {
    companion object {
        const val EXTRA_PROFILE = "extra_profile"
    }

    private var fav: GithubUserFav? = null
    private var isFavorite = false

    private lateinit var binding: ActivityGithubUserDetailBinding
    private lateinit var imageAvatar: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityGithubUserDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setData()
        binding.fabFavorite.setOnClickListener(this)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.option_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }

    private fun setData() {
        val user = intent.getParcelableExtra<GithubUser>(EXTRA_PROFILE) as GithubUser

        val tab1 = "${user.followers?.toInt()} ${getString(R.string.tab_text_1)}"
        val tab2 = "${user.following?.toInt()} ${getString(R.string.tab_text_2)}"

        detailName.text = if(user.name != "null") user.name.toString() else "Name Not Set"
        detailUsername.text = StringBuilder("@").append(user.username).toString()
        detailCompany.text = if(user.company != "null") user.company.toString() else "No Company"
        detailLocation.text = if(user.location != "null") user.location.toString() else "Location Not Set"

        Glide.with(this)
            .load(user.avatar)
            .apply(RequestOptions())
            .into(binding.imgProfileAvatar)


        imageAvatar = user?.avatar.toString()

        supportActionBar?.title = user.username + "'s Profile"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val tabTitles = arrayListOf(
            tab1,
            tab2
        )

        val sectionsPagerAdapter = SectionsPagerAdapter(this)
        val viewPager: ViewPager2 = findViewById(R.id.view_pager)

        viewPager.adapter = sectionsPagerAdapter
        val tabs: TabLayout = findViewById(R.id.tabs)

        TabLayoutMediator(tabs, viewPager) { tab, position ->
            tab.text = tabTitles[position]
        }.attach()
    }

    private fun setMode(selectedMode: Int) {
        when (selectedMode) {
            R.id.share -> {
                val userShare = intent.getParcelableExtra<GithubUser>(EXTRA_PROFILE) as GithubUser
                val shareIntent = Intent()
                shareIntent.action = Intent.ACTION_SEND
                shareIntent.type = "text/plain"
                shareIntent.putExtra(Intent.EXTRA_TEXT, "https://github.com/" + userShare.username)
                startActivity(Intent.createChooser(shareIntent, "Share via"))
            }
        }
    }

    override fun onClick(view: View) {
        val checked: Int = R.drawable.ic_baseline_favorite_24
        val unChecked: Int = R.drawable.ic_baseline_favorite_border_24
        if (view.id == R.id.fab_favorite) {
            if (isFavorite) {
//                favHelper.deleteById(fav?.username.toString())
                Toast.makeText(this, getString(R.string.delete_favorite), Toast.LENGTH_SHORT).show()
                fab_favorite.setImageResource(unChecked)
                isFavorite = false
            } else {
                val dataUsername = tv_username.text.toString()
                val dataName = tv_name.text.toString()
                val dataAvatar = imageAvatar
                val dataCompany = tv_company.text.toString()
                val dataFavorite = "1"

                Toast.makeText(this, getString(R.string.add_favorite), Toast.LENGTH_SHORT).show()
                fab_favorite.setImageResource(checked)
            }
        }
    }
}