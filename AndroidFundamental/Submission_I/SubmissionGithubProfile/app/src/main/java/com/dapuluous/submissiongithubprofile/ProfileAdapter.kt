package com.dapuluous.submissiongithubprofile

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class ProfileAdapter(private val listProfile: ArrayList<Profile>) : RecyclerView.Adapter<ProfileAdapter.ListViewHolder>() {
    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvUsername: TextView = itemView.findViewById(R.id.tv_profile_username)
        var tvName: TextView = itemView.findViewById(R.id.tv_profile_name)
        var tvProfilePicture: ImageView = itemView.findViewById(R.id.img_profile_avatar)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_row_profile, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val profile = listProfile[position]

        holder.tvUsername.text = "@" + profile.profileUsername
        holder.tvName.text = profile.profileName

        Glide.with(holder.itemView.context)
            .load(profile.profilePicture)
            .apply(RequestOptions().override(55, 55))
            .into(holder.tvProfilePicture)

        val mainContext = holder.itemView.context

        holder.itemView.setOnClickListener {
            val moveDetail = Intent(mainContext, ProfileDetail::class.java)
            moveDetail.putExtra(ProfileDetail.EXTRA_PROFILE, profile)
            mainContext.startActivity(moveDetail)
        }
    }

    override fun getItemCount(): Int {
        return listProfile.size
    }
}