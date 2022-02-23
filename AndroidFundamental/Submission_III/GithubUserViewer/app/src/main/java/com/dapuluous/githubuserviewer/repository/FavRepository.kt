package com.dapuluous.githubuserviewer.repository

import android.app.Application
import androidx.lifecycle.LiveData
import com.dapuluous.githubuserviewer.database.FavRoomDatabase
import com.dapuluous.githubuserviewer.database.Favorite
import com.dapuluous.githubuserviewer.database.FavoriteDao
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class FavRepository(application: Application) {
    private val mFavoritesDao: FavoriteDao
    private val executorService: ExecutorService = Executors.newSingleThreadExecutor()

    init {
        val db = FavRoomDatabase.getDatabase(application)
        mFavoritesDao = db.favoriteDao()
    }

    fun getAllNotes(): LiveData<List<Favorite>> = mFavoritesDao.getAllNotes()

    fun insert(favorite: Favorite) {
        executorService.execute { mFavoritesDao.insert(favorite) }
    }

    fun delete(favorite: Favorite) {
        executorService.execute { mFavoritesDao.delete(favorite) }
    }

    fun update(favorite: Favorite) {
        executorService.execute { mFavoritesDao.update(favorite) }
    }
}