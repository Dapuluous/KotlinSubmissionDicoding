package com.dapuluous.cookingrecipe

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class RecipeListAdapter(private val listRecipe: ArrayList<Recipe>) : RecyclerView.Adapter<RecipeListAdapter.ListViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_recipe, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val recipe = listRecipe[position]

        Glide.with(holder.itemView.context)
            .load(recipe.recipePhoto)
            .apply(RequestOptions().override(55, 55))
            .into(holder.imgPhoto)

        holder.tvName.text = recipe.recipeName
        holder.tvAuthor.text = recipe.recipeAuthor

        val mainContext = holder.itemView.context

        holder.itemView.setOnClickListener {
            val moveDetail = Intent(mainContext, RecipeDetail::class.java)
            moveDetail.putExtra(RecipeDetail.EXTRA_RECIPE_AUTHOR, recipe.recipeAuthor)
            moveDetail.putExtra(RecipeDetail.EXTRA_RECIPE_NAME, recipe.recipeName)
            moveDetail.putExtra(RecipeDetail.EXTRA_RECIPE_DETAIL, recipe.recipeDetail)
            moveDetail.putExtra(RecipeDetail.EXTRA_RECIPE_PHOTO, recipe.recipePhoto)
            mainContext.startActivity(moveDetail)
        }
    }

    override fun getItemCount(): Int {
        return listRecipe.size
    }

    inner class ListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        var tvAuthor: TextView = itemView.findViewById(R.id.tv_item_author)
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
    }

}