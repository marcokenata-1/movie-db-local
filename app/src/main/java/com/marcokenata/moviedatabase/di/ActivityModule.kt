package com.marcokenata.moviedatabase.di

import com.marcokenata.moviedatabase.ui.MainActivity
import com.marcokenata.moviedatabase.ui.MovieDetails
import com.marcokenata.moviedatabase.ui.MovieFavoriteHost
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {

    @ContributesAndroidInjector
    internal abstract fun mainActivity(): MainActivity

    @ContributesAndroidInjector
    internal abstract fun movieFavHost() : MovieFavoriteHost

    @ContributesAndroidInjector
    internal abstract fun movieDetails() : MovieDetails
}