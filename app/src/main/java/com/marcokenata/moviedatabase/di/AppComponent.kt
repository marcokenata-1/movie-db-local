package com.marcokenata.moviedatabase.di

import android.app.Application
import com.marcokenata.moviedatabase.MovieApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = arrayOf(
        ActivityModule::class,
        FragmentModule::class,
        NetModule::class,
        RoomModule::class,
        ViewModelFactoryModule::class,
        AndroidSupportInjectionModule::class,
        ViewModelModule::class
    )
)
interface AppComponent : AndroidInjector<MovieApplication> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder
        fun build(): AppComponent
    }

}