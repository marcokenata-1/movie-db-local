package com.marcokenata.moviedatabase.data.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.movieappv2.data.network.response.Result

@Entity(tableName = "movie_favorites")
class MovieFavorites(
    val movieId: Int,
    val movieResult: Result
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}