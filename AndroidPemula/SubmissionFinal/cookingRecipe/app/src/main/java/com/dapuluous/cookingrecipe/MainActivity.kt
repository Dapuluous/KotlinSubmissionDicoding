package com.dapuluous.cookingrecipe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.ListView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvRecipe: RecyclerView
    private var list: ArrayList<Recipe> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val actionBar = supportActionBar
        actionBar?.title = "Home"

        rvRecipe = findViewById(R.id.rv_recipe)
        rvRecipe.setHasFixedSize(true)

        list.addAll(RecipesData.listData)
        showRecyclerList()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }

    private fun setMode(selectedMode: Int) {
        when (selectedMode) {
            R.id.action_about -> {
                val intentAbout = Intent(this@MainActivity, AboutMe::class.java)
                startActivity(intentAbout)
            }
        }
    }

    private fun showRecyclerList() {
        rvRecipe.layoutManager = LinearLayoutManager(this)
        val recipeListAdapter = RecipeListAdapter(list)
        rvRecipe.adapter = recipeListAdapter
    }
}