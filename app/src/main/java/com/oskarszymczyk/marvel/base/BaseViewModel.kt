package com.oskarszymczyk.marvel.base

import android.arch.lifecycle.ViewModel
import com.oskarszymczyk.marvel.di_components.DaggerViewModelInjector
import com.oskarszymczyk.marvel.di_components.ViewModelInjector
import com.oskarszymczyk.marvel.rest.NetworkManager
import com.oskarszymczyk.marvel.ui.main.MainViewModel

abstract class BaseViewModel : ViewModel() {
    private val injector: ViewModelInjector = DaggerViewModelInjector
            .builder()
            .networkModule(NetworkManager)
            .build()

    init {
        inject()
    }


    private fun inject() {
        when (this) {
            is MainViewModel -> injector.inject(this)
        }
    }
}