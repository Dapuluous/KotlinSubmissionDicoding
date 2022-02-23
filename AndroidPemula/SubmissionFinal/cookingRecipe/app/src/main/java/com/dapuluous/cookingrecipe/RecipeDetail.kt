package com.dapuluous.cookingrecipe

import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class RecipeDetail : AppCompatActivity() {
    companion object {
        const val EXTRA_RECIPE_AUTHOR = "extra_recipe_author"
        const val EXTRA_RECIPE_NAME = "extra_recipe_name"
        const val EXTRA_RECIPE_DETAIL = "extra_recipe_detail"
        const val EXTRA_RECIPE_PHOTO = "extra_recipe_photo"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe_detail)

        val actionBar = supportActionBar
        actionBar?.title = "Recipe Detail"
        actionBar?.setDisplayHomeAsUpEnabled(true)

        val tvSetAuthor: TextView = findViewById(R.id.tv_item_author)
        val tvSetName: TextView = findViewById(R.id.tv_item_name)
        val tvSetDetail: TextView = findViewById(R.id.tv_item_detail)
        val tvSetPhoto: ImageView = findViewById(R.id.img_item_photo)

        val intentAuthor = intent.getStringExtra(EXTRA_RECIPE_AUTHOR)
        val intentName = intent.getStringExtra(EXTRA_RECIPE_NAME)
        val intentDetail = intent.getStringExtra(EXTRA_RECIPE_DETAIL)
        val intentPhoto = intent.getIntExtra(EXTRA_RECIPE_PHOTO, 0)

        tvSetAuthor.text = intentAuthor
        tvSetName.text = intentName
        tvSetDetail.text = intentDetail

        Glide.with(this)
            .load(intentPhoto)
            .apply(RequestOptions())
            .into(tvSetPhoto)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}