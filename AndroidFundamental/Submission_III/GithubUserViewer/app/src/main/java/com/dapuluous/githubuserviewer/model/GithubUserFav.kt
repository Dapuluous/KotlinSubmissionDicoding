package com.dapuluous.githubuserviewer.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class GithubUserFav (
    val username: String?,
    val name: String?,
    val avatar: String?,
    val company: String?,
    val isFav: String?
): Parcelable