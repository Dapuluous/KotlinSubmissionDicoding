package com.dapuluous.submissiongithubprofile

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Profile(
    val profileUsername: String?,
    val profileName: String?,
    val profilePicture: Int?,
    val profileCompany: String?,
    val profileLocation: String?,
    val profileRepository: String?,
    val profileFollower: String?,
    val profileFollowing: String?
    ): Parcelable