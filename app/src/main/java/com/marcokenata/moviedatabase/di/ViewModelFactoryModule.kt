package com.marcokenata.moviedatabase.di

import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelFactoryModule {

    @Binds
    abstract fun bindViewModelFactory(daggerViewModelFactory : DaggerViewModelFactory) : ViewModelProvider.Factory
}