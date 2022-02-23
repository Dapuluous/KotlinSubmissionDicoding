package com.dapuluous.githubuserviewer

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

var followersFilterList = ArrayList<GithubUser>()

class FollowersAdapter(listUsers: ArrayList<GithubUser>) :
    RecyclerView.Adapter<FollowersAdapter.ListViewHolder>() {
    init {
        followersFilterList = listUsers
    }

    private var onItemClickCallback: OnItemClickCallback? = null

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(parent: ViewGroup, i: Int): ListViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_users, parent, false)
        val sch = ListViewHolder(view)
        mainContext = parent.context
        return sch
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val data = followersFilterList[position]
        Glide.with(holder.itemView.context)
            .load(data.avatar)
            .apply(RequestOptions().override(200, 200))
            .into(holder.listAvatar)
        holder.listUsername.text = data.username
        holder.listName.text = data.name

        holder.itemView.setOnClickListener {
            //DO NOTHING
        }
    }

    interface OnItemClickCallback {
        fun onItemClicked(UserData: GithubUser)
    }

    override fun getItemCount(): Int = followersFilterList.size

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var listAvatar: ImageView = itemView.findViewById(R.id.img_profile_avatar)
        var listUsername: TextView = itemView.findViewById(R.id.tv_name)
        var listName: TextView = itemView.findViewById(R.id.tv_username)
    }

}