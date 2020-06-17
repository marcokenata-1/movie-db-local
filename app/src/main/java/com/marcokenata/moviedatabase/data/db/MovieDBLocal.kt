package com.marcokenata.moviedatabase.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.marcokenata.moviedatabase.data.converters.Converters

@Database(
    entities = [MovieFavorites::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class MovieDBLocal : RoomDatabase() {
    abstract fun movieDao(): MovieDao
}