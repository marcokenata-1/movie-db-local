package com.marcokenata.moviedatabase.data.db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [MovieFavorites::class],
    version = 1,
    exportSchema = false
)
abstract class MovieDBLocal() : RoomDatabase() {
    abstract fun movieDao(): MovieDao
}