package com.oskarszymczyk.suhero.extensions

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.support.v4.app.Fragment

fun <T : ViewModel> Fragment.createVieModel(viewModelFactory: ViewModelProvider.Factory, modelClass: Class<T>) =
        ViewModelProviders.of(this, viewModelFactory).get(modelClass)


//inline fun <reified T : ViewModel> createViewModel(fragment: Fragment): T {
//    val factory = Injector.getViewModelFactory()
//    return ViewModelProviders.of(fragment, factory).get(T::class.java)
//}
//
//inline fun <reified T : ViewModel> Fragment.viewModelDelegate() = lazy { createViewModel<T>(this) }