package com.dapuluous.submissiongithubprofile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvProfile: RecyclerView
    private var list:ArrayList<Profile> = arrayListOf()

    val listData: ArrayList<Profile> get() {
        val profileUsernames = resources.getStringArray(R.array.username)
        val profileNames = resources.getStringArray(R.array.name)
        val profilePictures = resources.obtainTypedArray(R.array.avatar)
        val profileCompanies = resources.getStringArray(R.array.company)
        val profileLocations = resources.getStringArray(R.array.location)
        val profileRepositories = resources.getStringArray(R.array.repository)
        val profileFollowers = resources.getStringArray(R.array.followers)
        val profileFollowings = resources.getStringArray(R.array.following)

        val listProfile = ArrayList<Profile>()

        for (x in profileUsernames.indices) {
            val profile = Profile(profileUsernames[x],
                profileNames[x],
                profilePictures.getResourceId(x, -1),
                profileCompanies[x],
                profileLocations[x],
                profileRepositories[x],
                profileFollowers[x],
                profileFollowings[x])
            listProfile.add(profile)
        }
        return listProfile
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val actionBar = supportActionBar
        actionBar?.title = "Home"

        rvProfile = findViewById(R.id.rv_profile)
        rvProfile.setHasFixedSize(true)

        list.addAll(listData)
        showRecyclerList()
    }

    private fun showRecyclerList() {
        rvProfile.layoutManager = LinearLayoutManager(this)
        val profileAdapter = ProfileAdapter(list)
        rvProfile.adapter = profileAdapter
    }
}