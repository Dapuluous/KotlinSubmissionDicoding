package com.dapuluous.githubuserviewer.ui.insert

import android.app.Application
import androidx.lifecycle.ViewModel
import com.dapuluous.githubuserviewer.database.Favorite
import com.dapuluous.githubuserviewer.repository.FavRepository

class GithubUserDetailViewModel(application: Application) : ViewModel() {
    private val mNoteRepository: FavRepository = FavRepository(application)
    fun insert(fav: Favorite) {
        mNoteRepository.insert(fav)
    }
    fun update(fav: Favorite) {
        mNoteRepository.update(fav)
    }
    fun delete(fav: Favorite) {
        mNoteRepository.delete(fav)
    }
}