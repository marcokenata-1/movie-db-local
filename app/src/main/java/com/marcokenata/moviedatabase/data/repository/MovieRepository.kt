package com.marcokenata.moviedatabase.data.repository

import androidx.lifecycle.LiveData
import com.marcokenata.moviedatabase.data.db.MovieDBDataSource
import com.marcokenata.moviedatabase.data.db.MovieFavorites
import com.marcokenata.moviedatabase.data.network.MovieDataSource
import com.marcokenata.moviedatabase.data.network.response.DataResponse
import com.marcokenata.moviedatabase.data.network.response.Result
import com.marcokenata.moviedatabase.data.network.response.ReviewResponse
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

@Module
class MovieRepository @Inject constructor(
    private val movieDataSource: MovieDataSource,
    private val movieDBDataSource: MovieDBDataSource
) {

    @Provides
    suspend fun fetchPopularMoviesRepo(page: Int): LiveData<DataResponse> {
        return withContext(Dispatchers.IO){
            movieDataSource.fetchPopularMovies(page)
            return@withContext movieDataSource.popularMovies
        }
    }

    @Provides
    suspend fun fetchTopRatedMoviesRepo(page: Int): LiveData<DataResponse> {
        return withContext(Dispatchers.IO){
            movieDataSource.fetchTopRatedMovies(page)
            return@withContext movieDataSource.topRatedMovies
        }
    }

    @Provides
    suspend fun fetchNowPlayingMoviesRepo(page: Int) : LiveData<DataResponse> {
        return withContext(Dispatchers.IO){
            movieDataSource.fetchNowPlaying(page)
            return@withContext movieDataSource.movieNowPlaying
        }
    }

    @Provides
    suspend fun fetchMovieDetailsRepo(id: Int) : LiveData<Result> {
        return withContext(Dispatchers.IO){
            movieDataSource.fetchMovieDetails(id)
            return@withContext movieDataSource.movieDetails
        }
    }

    @Provides
    suspend fun fetchMovieReviewRepo(id: Int) : LiveData<ReviewResponse> {
        return withContext(Dispatchers.IO){
            movieDataSource.fetchMovieReview(id)
            return@withContext movieDataSource.movieReview
        }
    }

    @Provides
    suspend fun insertFavorite(movieFavorites: MovieFavorites){
        return withContext(Dispatchers.IO){
            movieDBDataSource.insertFavorite(movieFavorites)
        }
    }

    @Provides
    suspend fun deleteFavorite(id: Int){
        return withContext(Dispatchers.IO){
            movieDBDataSource.removeFavorite(id)
        }
    }

    @Provides
    suspend fun checkFavorite(id: Int) : LiveData<MovieFavorites>{
        return withContext(Dispatchers.IO){
            movieDBDataSource.checkFavorite(id)
            return@withContext movieDBDataSource.movieChecker
        }
    }

    @Provides
    suspend fun favoriteList() : LiveData<List<MovieFavorites>>{
        return withContext(Dispatchers.IO){
            movieDBDataSource.favoriteList()
            return@withContext movieDBDataSource.favoriteMovies
        }
    }



}