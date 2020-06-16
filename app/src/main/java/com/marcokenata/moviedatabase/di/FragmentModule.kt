package com.marcokenata.moviedatabase.di

import com.marcokenata.moviedatabase.ui.nowplaying.NowPlaying
import com.marcokenata.moviedatabase.ui.popular.Popular
import com.marcokenata.moviedatabase.ui.toprated.TopRated
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentModule {

    @ContributesAndroidInjector
    internal abstract fun nowPlaying() : NowPlaying

    @ContributesAndroidInjector
    internal abstract fun popular() : Popular

    @ContributesAndroidInjector
    internal abstract fun topRated() : TopRated
}