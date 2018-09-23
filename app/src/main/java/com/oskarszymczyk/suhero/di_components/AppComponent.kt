package com.oskarszymczyk.suhero.di_components

import android.app.Application
import com.oskarszymczyk.core.rest.NetworkModule
import com.oskarszymczyk.suhero.SuHeroApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
        modules = [
            AndroidInjectionModule::class,
            ViewModelModule::class,
            NetworkModule::class,
            WelcomeActivityModule::class]
)
interface AppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(suHeroApplication: SuHeroApplication)
}