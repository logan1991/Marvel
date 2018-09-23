package com.oskarszymczyk.suhero.extensions

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.support.v4.app.Fragment

fun <T : ViewModel> Fragment.createVieModel(viewModelFactory: ViewModelProvider.Factory, modelClass: Class<T>) =
        ViewModelProviders.of(this, viewModelFactory).get(modelClass)