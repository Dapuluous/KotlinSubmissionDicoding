package com.dapuluous.githubuserviewer.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.dapuluous.githubuserviewer.model.GithubUser
import com.dapuluous.githubuserviewer.R

var followingFilterList = ArrayList<GithubUser>()

class FollowingAdapter(listUsers: ArrayList<GithubUser>) :
    RecyclerView.Adapter<FollowingAdapter.ListViewHolder>() {
    init {
        followingFilterList = listUsers
    }

    override fun onCreateViewHolder(parent: ViewGroup, i: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_users, parent, false)
        val sch = ListViewHolder(view)
        mainContext = parent.context
        return sch
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val data = followingFilterList[position]
        Glide.with(holder.itemView.context)
            .load(data.avatar)
            .apply(RequestOptions().override(200, 200))
            .into(holder.listAvatar)
        holder.listUsername.text = data.username
        holder.listName.text = data.name
    }

    override fun getItemCount(): Int = followingFilterList.size

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var listAvatar: ImageView = itemView.findViewById(R.id.img_profile_avatar)
        var listUsername: TextView = itemView.findViewById(R.id.tv_username)
        var listName: TextView = itemView.findViewById(R.id.tv_name)
    }

}