package com.marcokenata.moviedatabase.di

import com.marcokenata.moviedatabase.MovieApplication
import dagger.Module
import dagger.Provides

@Module
class AppModule {

    @Provides
    fun application() : MovieApplication{
        return MovieApplication()
    }
}