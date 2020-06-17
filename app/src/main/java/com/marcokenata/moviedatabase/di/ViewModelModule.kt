package com.marcokenata.moviedatabase.di

import androidx.lifecycle.ViewModel
import com.marcokenata.moviedatabase.ui.favorites.FavoritesViewModel
import com.marcokenata.moviedatabase.ui.nowplaying.NowPlayingViewModel
import com.marcokenata.moviedatabase.ui.popular.PopularViewModel
import com.marcokenata.moviedatabase.ui.toprated.TopRatedViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
internal abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(NowPlayingViewModel::class)
    abstract fun nowPlayingViewModel(viewModel: NowPlayingViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(PopularViewModel::class)
    abstract fun popularViewModel(viewModel: PopularViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(TopRatedViewModel::class)
    abstract fun topRatedViewModel(viewModel: TopRatedViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(FavoritesViewModel::class)
    abstract fun favoritesViewModel(viewModel: FavoritesViewModel): ViewModel

}