package com.marcokenata.moviedatabase.di

import androidx.lifecycle.ViewModel
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
    internal abstract fun nowPlayingViewModel(nowPlayingViewModel: NowPlayingViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(PopularViewModel::class)
    internal abstract fun popularViewModel(popularViewModel: PopularViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(TopRatedViewModel::class)
    internal abstract fun topRatedViewModel(topRatedViewModel: TopRatedViewModel): ViewModel


}