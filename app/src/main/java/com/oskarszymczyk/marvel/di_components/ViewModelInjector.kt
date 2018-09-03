package com.oskarszymczyk.marvel.di_components

import com.oskarszymczyk.marvel.rest.NetworkManager
import com.oskarszymczyk.marvel.ui.main.MainViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkManager::class])
interface ViewModelInjector {

    fun inject(mainViewModel: MainViewModel)

    @Component.Builder
    interface Builder {
        fun build(): ViewModelInjector

        fun networkModule(networkManger: NetworkManager): Builder
    }
}