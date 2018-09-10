package com.oskarszymczyk.marvel.di_components

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.oskarszymczyk.marvel.base.ViewModelFactory
import com.oskarszymczyk.marvel.ui.welcome.WelcomeViewModel
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
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}