package com.dapuluous.submissiongithubprofile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class ProfileDetail : AppCompatActivity() {
    companion object {
        const val EXTRA_PROFILE = "extra_profile"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_detail)

        val profileUsername: TextView = findViewById(R.id.profile_detail_username)
        val profileName: TextView = findViewById(R.id.profile_detail_name)
        val profilePic: ImageView = findViewById(R.id.img_profile_avatar)
        val profileFollower: TextView = findViewById(R.id.profile_detail_follower)
        val profileFollowing: TextView = findViewById(R.id.profile_detail_following)
        val profileTotalRepository: TextView = findViewById(R.id.profile_detail_totalrepository)
        val profileWorkplace: TextView = findViewById(R.id.profile_detail_workplace)
        val profileUserLocation: TextView = findViewById(R.id.profile_detail_location)

        val profile = intent.getParcelableExtra<Profile>(EXTRA_PROFILE) as Profile

        // Menampilkan Data Ke Halaman Detail
        profileUsername.text = "@" + profile.profileUsername.toString()
        profileName.text = profile.profileName.toString()
        profileFollower.text = profile.profileFollower.toString() + " Followers"
        profileFollowing.text = profile.profileFollowing.toString() + " Following"
        profileTotalRepository.text = profile.profileRepository.toString() + " Repository"
        profileWorkplace.text = "Works At " + profile.profileCompany.toString()
        profileUserLocation.text = "Lives At " + profile.profileLocation.toString()

        Glide.with(this)
            .load(profile.profilePicture)
            .apply(RequestOptions())
            .into(profilePic)

        val actionBar = supportActionBar
        actionBar?.title = profile.profileUsername + "'s Profile"
        actionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}