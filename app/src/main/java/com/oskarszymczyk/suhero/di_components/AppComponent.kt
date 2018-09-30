package com.oskarszymczyk.suhero.di_components

import android.app.Application
import android.arch.lifecycle.ViewModelProvider
import com.oskarszymczyk.core.localdata.sharedpreferences.SharedPreferencesModule
import com.oskarszymczyk.core.rest.NetworkModule
import com.oskarszymczyk.suhero.NavigationFactory
import com.oskarszymczyk.suhero.SuHeroApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton


@Component(
        modules = [
            AppModule::class,
            AndroidInjectionModule::class,
            ViewModelModule::class,
            NetworkModule::class,
            SharedPreferencesModule::class,
            MainActivityModule::class]
)
@Singleton
interface AppComponent {
    fun viewModelFactory(): ViewModelProvider.Factory
    fun navigationFactory(): NavigationFactory


    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(suHeroApplication: SuHeroApplication)

}