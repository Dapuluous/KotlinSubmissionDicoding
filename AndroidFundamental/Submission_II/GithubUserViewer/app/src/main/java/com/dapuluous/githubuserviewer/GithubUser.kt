package com.dapuluous.githubuserviewer

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class GithubUser(
    val username: String?,
    val name: String?,
    val avatar: String?,
    val company: String?,
    val location: String?
): Parcelable
