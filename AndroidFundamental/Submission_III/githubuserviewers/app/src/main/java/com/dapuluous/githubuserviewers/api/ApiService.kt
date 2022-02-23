package com.dapuluous.githubuserviewers.api

import com.dapuluous.githubuserviewers.model.DetailResponse
import com.dapuluous.githubuserviewers.model.ItemsItem
import com.dapuluous.githubuserviewers.model.UserResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("search/users")
    @Headers("Authorization: token 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")
    fun getSearchUsers(
        @Query("q") query: String
    ): Call<UserResponse>

    @GET("users/{username}")
    @Headers("Authorization: token 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")
    fun getUserDetail(
        @Path("username") username: String
    ): Call<DetailResponse>

    @GET("users/{username}/followers")
    @Headers("Authorization: token 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")
    fun getFollowers(
        @Path("username") username: String
    ): Call<ArrayList<ItemsItem>>

    @GET("users/{username}/following")
    @Headers("Authorization: token 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")
    fun getFollowing(
        @Path("username") username: String
    ): Call<ArrayList<ItemsItem>>
}