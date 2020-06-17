package com.marcokenata.moviedatabase.data.db

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

@Module
class MovieDBDataSource @Inject constructor(private val movieDao: MovieDao){

    private val _favoriteMovies = MutableLiveData<List<MovieFavorites>>()

     val favoriteMovies : LiveData<List<MovieFavorites>>
        get() = _favoriteMovies

    private val _movieChecker = MutableLiveData<MovieFavorites>()

     val movieChecker : LiveData<MovieFavorites>
        get() = _movieChecker

    @Provides
    suspend fun insertFavorite(movieFavorites: MovieFavorites){
        return withContext(Dispatchers.IO){
            movieDao.insertFavorite(movieFavorites)
        }
    }

    @Provides
    suspend fun removeFavorite(movieFavorites: MovieFavorites){
        return withContext(Dispatchers.IO){
            movieDao.removeFavorite(movieFavorites)
        }
    }

    @Provides
    suspend fun checkFavorite(id: Int){
        return withContext(Dispatchers.IO){
            _movieChecker.postValue(movieDao.checkinFavorites(id))
        }
    }

    @Provides
    suspend fun favoriteList(){
        return withContext(Dispatchers.IO){
            _favoriteMovies.postValue(movieDao.showFavorite())
        }
    }


}