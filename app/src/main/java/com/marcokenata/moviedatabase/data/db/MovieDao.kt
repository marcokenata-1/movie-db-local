package com.marcokenata.moviedatabase.data.db

import androidx.room.*

@Dao
interface MovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertFavorite(movieFavorites: MovieFavorites)

    @Query("delete from movie_favorites where movieId like :id")
    fun removeFavorite(id: Int)

    @Query("select * from movie_favorites")
    fun showFavorite() : List<MovieFavorites>

    @Query("select * from movie_favorites where movieId like :id ")
    fun checkinFavorites(id : Int) : MovieFavorites

}