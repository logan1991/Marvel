package com.oskarszymczyk.suhero.extensions

import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import com.oskarszymczyk.suhero.di_components.AppInjector

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