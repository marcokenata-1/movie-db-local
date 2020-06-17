package com.marcokenata.moviedatabase.data.network

import com.marcokenata.moviedatabase.data.network.response.DataResponse
import com.marcokenata.moviedatabase.data.network.response.Result
import com.marcokenata.moviedatabase.data.network.response.ReviewResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieDBService {

    @GET("popular?")
    fun getPopular(
        @Query("language") language: String = "en-US",
        @Query("page") page: Int
    ): Call<DataResponse>

    @GET("top_rated?")
    fun getTopRated(
        @Query("language") language: String = "en-US",
        @Query("page") page: Int
    ): Call<DataResponse>

    @GET("now_playing?")
    fun getNowPlaying(
        @Query("language") language: String = "en-US",
        @Query("page") page: Int
    ): Call<DataResponse>

    @GET("/{id}")
    fun getMovieDetails(
        @Path("id") movieId: Int
    ): Call<Result>


    @GET("/{id}/reviews")
    fun getMovieReviews(
        @Path("id") movieId: Int
    ): Call<ReviewResponse>

}