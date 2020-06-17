package com.marcokenata.moviedatabase.ui.favorites

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.marcokenata.moviedatabase.data.db.MovieFavorites
import com.marcokenata.moviedatabase.data.network.response.DataResponse
import com.marcokenata.moviedatabase.data.repository.MovieRepository
import kotlinx.coroutines.*
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class FavoritesViewModel @Inject constructor(private val movieRepository: MovieRepository) :
    ViewModel(), CoroutineScope {

    override val coroutineContext: CoroutineContext
        get() = SupervisorJob() + Dispatchers.Main

    override fun onCleared() {
        super.onCleared()
        coroutineContext.cancel()
    }

    val favorites = MutableLiveData<List<MovieFavorites>>()

    init {
        launch {
            favorites.value = movieRepository.favoriteList().value
        }
    }
}