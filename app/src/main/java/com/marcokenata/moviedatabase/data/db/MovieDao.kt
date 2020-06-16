package com.marcokenata.moviedatabase.data.db

import androidx.room.*

@Dao
interface MovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertFavorite(movieFavorites: MovieFavorites)

    @Delete
    fun removeFavorite(movieFavorites: MovieFavorites)

    @Query("select * from movie_favorites")
    fun showFavorite() : List<MovieFavorites>

    @Query("select * from movie_favorites where id like :id ")
    fun checkinFavorites(id : Int) : List<MovieFavorites>

}