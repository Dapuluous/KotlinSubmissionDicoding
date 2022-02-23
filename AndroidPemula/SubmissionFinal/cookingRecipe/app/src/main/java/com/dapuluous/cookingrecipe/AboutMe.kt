package com.dapuluous.cookingrecipe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class AboutMe : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_me)

        val actionBar = supportActionBar
        actionBar?.title = "About Me"
        actionBar?.setDisplayHomeAsUpEnabled(true)

        val fotoSendiri: ImageView = findViewById(R.id.img_profile)
        val fileFoto = R.drawable.dapoo

        Glide.with(this)
            .load(fileFoto)
            .apply(RequestOptions())
            .into(fotoSendiri)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}