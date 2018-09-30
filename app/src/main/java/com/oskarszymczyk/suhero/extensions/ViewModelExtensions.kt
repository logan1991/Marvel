package com.oskarszymczyk.suhero.extensions

import android.arch.lifecycle.ViewModel
import androidx.navigation.NavController
import com.oskarszymczyk.suhero.di_components.AppInjector

fun ViewModel.getNavController(): NavController {
    val factory = AppInjector.getNavigationFactory()
    return factory.getSpecyficNavController()
}