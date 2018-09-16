package com.oskarszymczyk.marvel.di_components

import android.app.Application
import com.oskarszymczyk.core.rest.NetworkManager
import com.oskarszymczyk.marvel.SuHero
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
        modules = [
            AndroidInjectionModule::class,
            ViewModelModule::class,
            NetworkManager::class,
            WelcomeActivityModule::class]
)
interface AppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(suHero: SuHero)
}