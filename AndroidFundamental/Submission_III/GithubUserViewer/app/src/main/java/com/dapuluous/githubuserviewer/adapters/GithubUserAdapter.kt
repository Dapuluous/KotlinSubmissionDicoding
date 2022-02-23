package com.dapuluous.githubuserviewer.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.dapuluous.githubuserviewer.ui.insert.GithubUserDetailActivity
import com.dapuluous.githubuserviewer.R
import com.dapuluous.githubuserviewer.model.GithubUser
import java.util.*
import kotlin.collections.ArrayList

var userFilterList = ArrayList<GithubUser>()

@SuppressLint("StaticFieldLeak")
lateinit var mainContext: Context

class GithubUserAdapter(private val listUsers: ArrayList<GithubUser>) :
    RecyclerView.Adapter<GithubUserAdapter.ViewHolder>(), Filterable {
    init {
        userFilterList = listUsers
    }

    private var onItemClickCallback: OnItemClickCallback? = null

    interface OnItemClickCallback {
        fun onItemClicked(dataUsers: GithubUser)
    }

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_users, viewGroup, false)
        mainContext = viewGroup.context
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val user = userFilterList[position]

        Glide.with(viewHolder.itemView.context)
            .load(user.avatar)
            .apply(RequestOptions().override(250, 250))
            .into(viewHolder.listAvatar)
        viewHolder.listUsername.text = user.username
        viewHolder.listName.text = if(user.name != "null") user.name.toString() else "Name Not Set"

        viewHolder.itemView.setOnClickListener {
            val dataUser = GithubUser(
                user.username,
                user.name,
                user.avatar,
                user.company,
                user.location,
                user.followers,
                user.following
            )
            val intentDetail = Intent(mainContext, GithubUserDetailActivity::class.java)
            intentDetail.putExtra(GithubUserDetailActivity.EXTRA_PROFILE, dataUser)
            mainContext.startActivity(intentDetail)
        }
    }

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence): FilterResults {
                val charSearch = constraint.toString()
                userFilterList = if (charSearch.isEmpty()) {
                    listUsers
                } else {
                    val resultList = ArrayList<GithubUser>()
                    for (row in userFilterList) {
                        if ((row.username.toString().lowercase(Locale.ROOT)
                                .contains(charSearch.lowercase(Locale.ROOT)))
                        ) {
                            resultList.add(
                                GithubUser(
                                    row.username,
                                    row.name,
                                    row.avatar,
                                    row.company,
                                    row.location,
                                    row.followers,
                                    row.following
                                )
                            )
                        }
                    }
                    resultList
                }
                val filterResults = FilterResults()
                filterResults.values = userFilterList
                return filterResults
            }

            @SuppressLint("NotifyDataSetChanged")
            @Suppress("UNCHECKED_CAST")
            override fun publishResults(constraint: CharSequence, results: FilterResults) {
                userFilterList = results.values as ArrayList<GithubUser>
                notifyDataSetChanged()
            }
        }
    }

    override fun getItemCount(): Int {
        return listUsers.size
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var listAvatar: ImageView = itemView.findViewById(R.id.img_profile_avatar)
        var listUsername: TextView = itemView.findViewById(R.id.tv_username)
        var listName: TextView = itemView.findViewById(R.id.tv_name)
    }
}