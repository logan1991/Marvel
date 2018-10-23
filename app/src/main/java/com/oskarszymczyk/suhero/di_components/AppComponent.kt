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
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton


@Component(
        modules = [
            AppModule::class,
            AndroidSupportInjectionModule::class,
            NetworkModule::class,
            SharedPreferencesModule::class,
            MainActivityModule::class]
)
@Singleton
interface AppComponent : AndroidInjector<DaggerApplication>{
    fun navigationFactory(): NavigationFactory


    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(suHeroApplication: SuHeroApplication)

    override
    fun inject(instance: DaggerApplication)
}