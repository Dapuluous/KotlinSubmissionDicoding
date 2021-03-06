package com.dapuluous.githubuserviewers.controller

import android.content.ContentValues
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dapuluous.githubuserviewers.api.ApiConfig
import com.dapuluous.githubuserviewers.model.ItemsItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FollowersViewModel : ViewModel() {
    val listFollowers = MutableLiveData<ArrayList<ItemsItem>>()

    fun setListFollowers(username: String) {
        val client = ApiConfig.getApiService().getFollowers(username)
        client.enqueue(object : Callback<ArrayList<ItemsItem>> {
            override fun onResponse(
                call: Call<ArrayList<ItemsItem>>,
                response: Response<ArrayList<ItemsItem>>
            ) {
                if (response.isSuccessful) {
                    listFollowers.postValue(response.body())
                } else {
                    Log.e(ContentValues.TAG, "onFailure: ${response.message()}")
                }
            }
            override fun onFailure(call: Call<ArrayList<ItemsItem>>, t: Throwable) {
                Log.e(ContentValues.TAG, "onFailure: ${t.message}")
            }
        })
    }

    fun getListFollowers() : LiveData<ArrayList<ItemsItem>> {
        return listFollowers
    }
}