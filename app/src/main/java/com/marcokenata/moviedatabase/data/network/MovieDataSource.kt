package com.marcokenata.moviedatabase.data.network

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.marcokenata.moviedatabase.data.network.response.DataResponse
import com.marcokenata.moviedatabase.data.network.response.Result
import com.marcokenata.moviedatabase.data.network.response.ReviewResponse
import dagger.Module
import dagger.Provides
import retrofit2.await
import java.io.IOException
import javax.inject.Inject

@Module
class MovieDataSource @Inject constructor(private val movieDBService: MovieDBService) {

    private val _popularMovies = MutableLiveData<DataResponse>()

    val popularMovies: LiveData<DataResponse>
        get() = _popularMovies

    private val _topRatedMovies = MutableLiveData<DataResponse>()

    val topRatedMovies: LiveData<DataResponse>
        get() = _topRatedMovies

    private val _movieNowPlaying = MutableLiveData<DataResponse>()

    val movieNowPlaying: LiveData<DataResponse>
        get() = _movieNowPlaying

    private val _movieDetails = MutableLiveData<Result>()

    val movieDetails: LiveData<Result>
        get() = _movieDetails

    private val _movieReview = MutableLiveData<ReviewResponse>()

    val movieReview: LiveData<ReviewResponse>
        get() = _movieReview

    @Provides
    suspend fun fetchPopularMovies(page: Int) {
        try {

            val fetchedMovieDBService = movieDBService
                .getPopular("en-US", page)
                .await()

            _popularMovies.postValue(fetchedMovieDBService)


        } catch (e: IOException) {
            Log.e("Connectivity", "No Internet Connection")
        }
    }

    @Provides
    suspend fun fetchTopRatedMovies(page: Int) {
        try {
            val fetchedMovieDBService = movieDBService
                .getTopRated("en-US", page)
                .await()


            _topRatedMovies.postValue(fetchedMovieDBService)

        } catch (e: IOException) {
            Log.e("Connectivity", "No Internet Connection")
        }
    }

    @Provides
    suspend fun fetchNowPlaying(page: Int) {
        try {
            val fetchedMovieDBService = movieDBService
                .getNowPlaying("en-US", page)
                .await()


            _movieNowPlaying.postValue(fetchedMovieDBService)

        } catch (e: IOException) {
            Log.e("Connectivity", "No Internet Connection")
        }
    }

    @Provides
    suspend fun fetchMovieDetails(id: Int) {
        try {
            val fetchedMovieDBService = movieDBService
                .getMovieDetails(id)
                .await()


            _movieDetails.postValue(fetchedMovieDBService)

        } catch (e: IOException) {
            Log.e("Connectivity", "No Internet Connection")
        }
    }

    @Provides
    suspend fun fetchMovieReview(id: Int) {
        try {
            val fetchedMovieDBService = movieDBService
                .getMovieReviews(id)
                .await()


            _movieReview.postValue(fetchedMovieDBService)

        } catch (e: IOException) {
            Log.e("Connectivity", "No Internet Connection")
        }
    }


}