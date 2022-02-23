package com.dapuluous.githubuserviewers.controller

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.dapuluous.githubuserviewers.database.FavoriteUser
import com.dapuluous.githubuserviewers.database.FavoriteUserDao
import com.dapuluous.githubuserviewers.database.FavoriteUserRoomDatabase

class FavoriteViewModel(application: Application) : ViewModel() {
    private val mFavoriteUserDao: FavoriteUserDao

    init {
        val db = FavoriteUserRoomDatabase.getDatabase(application)
        mFavoriteUserDao = db.favoriteUserDao()
    }

    fun getAllFavoriteUser(): LiveData<List<FavoriteUser>> = mFavoriteUserDao.getFavoriteUser()
}