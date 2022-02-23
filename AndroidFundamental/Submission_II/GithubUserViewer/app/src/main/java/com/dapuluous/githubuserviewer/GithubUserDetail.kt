package com.dapuluous.githubuserviewer

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.annotation.StringRes
import androidx.viewpager2.widget.ViewPager2
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.dapuluous.githubuserviewer.databinding.ActivityGithubUserDetailBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class GithubUserDetail : AppCompatActivity() {
    companion object {
        const val EXTRA_PROFILE = "extra_profile"

        @StringRes
        private val TAB_TITLES = intArrayOf(
            R.string.tab_text_1,
            R.string.tab_text_2
        )
    }

    private lateinit var binding: ActivityGithubUserDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityGithubUserDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setData()

        val sectionsPagerAdapter = SectionsPagerAdapter(this)
        val viewPager: ViewPager2 = findViewById(R.id.view_pager)
        viewPager.adapter = sectionsPagerAdapter
        val tabs: TabLayout = findViewById(R.id.tabs)
        TabLayoutMediator(tabs, viewPager) { tab, position ->
            tab.text = resources.getString(TAB_TITLES[position])
        }.attach()
        supportActionBar?.elevation = 0f
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

    @SuppressLint("SetTextI18n", "StringFormatInvalid")
    private fun setData() {
        val user = intent.getParcelableExtra<GithubUser>(EXTRA_PROFILE) as GithubUser

        binding.detailName.text = user.name.toString()
        binding.detailUsername.text = StringBuilder("@").append(user.username).toString()
        binding.detailCompany.text = user.company.toString()
        binding.detailLocation.text = user.location.toString()

        Glide.with(this)
            .load(user.avatar)
            .apply(RequestOptions())
            .into(binding.imgProfileAvatar)

        supportActionBar?.title = user.username + "'s Profile"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
}