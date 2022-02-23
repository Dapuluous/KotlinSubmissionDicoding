package com.dapuluous.githubuserviewers

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatDelegate
import androidx.lifecycle.ViewModelProvider
import com.dapuluous.githubuserviewers.activity.HomeActivity
import com.dapuluous.githubuserviewers.activity.SettingPreferences
import com.dapuluous.githubuserviewers.activity.dataStore
import com.dapuluous.githubuserviewers.controller.SettingViewModel
import com.dapuluous.githubuserviewers.controller.SettingViewModelFactory
import com.dapuluous.githubuserviewers.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        val pref = SettingPreferences.getInstance(dataStore)
        val settingViewModel = ViewModelProvider(this, SettingViewModelFactory(pref)).get(
            SettingViewModel::class.java
        )
        settingViewModel.getThemeSettings().observe(this,
            { isDarkModeActive: Boolean ->
                if (isDarkModeActive) {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                } else {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                }
            }
        )

        setContentView(binding.root)
        supportActionBar?.hide()

        Handler(Looper.getMainLooper()).postDelayed({
            val homeIntent = Intent(this@MainActivity, HomeActivity::class.java)
            startActivity(homeIntent)
            finish()
        }, 3000)
    }
}