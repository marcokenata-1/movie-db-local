package com.marcokenata.moviedatabase.di

import android.app.Application
import androidx.room.Room
import com.marcokenata.moviedatabase.data.db.MovieDBLocal
import com.marcokenata.moviedatabase.data.db.MovieDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RoomModule {

    @Provides
    @Singleton
    fun provideDatabase(application: Application) : MovieDBLocal {
        return Room.databaseBuilder(
            application,
            MovieDBLocal::class.java,
            "movieDB.db"
        )
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideDao(movieDBLocal: MovieDBLocal) : MovieDao {
        return movieDBLocal.movieDao()
    }
}