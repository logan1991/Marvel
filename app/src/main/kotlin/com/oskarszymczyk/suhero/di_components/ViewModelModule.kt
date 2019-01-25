package com.oskarszymczyk.suhero.di_components

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.oskarszymczyk.suhero.base.ViewModelFactory
import com.oskarszymczyk.suhero.ui.main.MainViewModel
import com.oskarszymczyk.suhero.ui.splash.SplashViewModel
import com.oskarszymczyk.suhero.ui.welcome.WelcomeViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Suppress("unused")
@Module
abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(WelcomeViewModel::class)
    abstract fun bindWelcomeViewModel(welcomeViewModel: WelcomeViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(SplashViewModel::class)
    abstract fun bindSplashViewModel(splashViewModel: SplashViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindMainViewModel(mainViewModel: MainViewModel): MainViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}