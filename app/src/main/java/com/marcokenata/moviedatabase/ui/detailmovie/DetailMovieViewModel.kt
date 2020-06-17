package com.marcokenata.moviedatabase.ui.detailmovie

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.marcokenata.moviedatabase.data.db.MovieFavorites
import com.marcokenata.moviedatabase.data.network.response.Result
import com.marcokenata.moviedatabase.data.network.response.ReviewResponse
import com.marcokenata.moviedatabase.data.repository.MovieRepository
import kotlinx.coroutines.*
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class DetailMovieViewModel @Inject constructor(private val movieRepository: MovieRepository) :
    ViewModel(), CoroutineScope {
    override val coroutineContext: CoroutineContext
        get() = SupervisorJob() + Dispatchers.Main

    override fun onCleared() {
        super.onCleared()
        coroutineContext.cancel()
    }

    val details = MutableLiveData<Result>()

    val reviews = MutableLiveData<ReviewResponse>()

    val favoriteCheck = MutableLiveData<MovieFavorites>()

    fun getMovieDetails(id: Int) {
        launch {
            details.value = movieRepository.fetchMovieDetailsRepo(id).value
        }
    }

    fun getReview(id: Int){
        launch {
            reviews.value = movieRepository.fetchMovieReviewRepo(id).value
        }
    }

    fun checkFav(id: Int){
        launch {
            favoriteCheck.value = movieRepository.checkFavorite(id).value
        }
    }

    fun addtoFav(movieFavorites: MovieFavorites){
        launch {
            movieRepository.insertFavorite(movieFavorites)
        }
    }

    fun removeFav(id: Int){
        launch {
            movieRepository.deleteFavorite(id)
        }
    }


}