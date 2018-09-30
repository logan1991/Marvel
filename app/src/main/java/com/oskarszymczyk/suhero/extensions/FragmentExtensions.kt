package com.oskarszymczyk.suhero.extensions

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProviders
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import com.oskarszymczyk.suhero.di_components.AppInjector

inline fun <reified T : ViewModel> Fragment.viewModelDelegate() = lazy {
    createViewModel<T>(this)
}

inline fun <reified T : ViewModel> createViewModel(fragment: Fragment): T {
    val factory = AppInjector.getViewModelFactory()
    return ViewModelProviders.of(fragment, factory).get(T::class.java)
}

fun Fragment.setNavController() {
    val factoryNav = AppInjector.getNavigationFactory()
    factoryNav.createNavController(this)
}

fun Fragment.hideToolbar() {
    (activity as AppCompatActivity).supportActionBar?.hide()
}

fun Fragment.showToolbar() {
    (activity as AppCompatActivity).supportActionBar?.show()
}