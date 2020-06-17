package com.marcokenata.moviedatabase.di

import com.marcokenata.moviedatabase.ui.detailmovie.DetailMovie
import com.marcokenata.moviedatabase.ui.favorites.Favorites
import com.marcokenata.moviedatabase.ui.nowplaying.NowPlaying
import com.marcokenata.moviedatabase.ui.popular.Popular
import com.marcokenata.moviedatabase.ui.toprated.TopRated
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentModule {

    @ContributesAndroidInjector
    abstract fun nowPlaying() : NowPlaying

    @ContributesAndroidInjector
    abstract fun popular() : Popular

    @ContributesAndroidInjector
    abstract fun topRated() : TopRated

    @ContributesAndroidInjector
    abstract fun favorites() : Favorites

    @ContributesAndroidInjector
    abstract fun detailMovie() : DetailMovie
}