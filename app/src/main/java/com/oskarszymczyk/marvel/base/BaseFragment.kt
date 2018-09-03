package com.oskarszymczyk.marvel.base

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import com.oskarszymczyk.marvel.ui.main.MainFragment
import com.oskarszymczyk.marvel.ui.main.MainViewModel

open class BaseFragment<T : BaseViewModel> : Fragment() {


    lateinit var viewModel: T

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModelFactory()
        val viewModelFactory = viewModel.createFactory()
        ViewModelProviders.of(this, viewModelFactory).get(viewModel::class.java)

    }

    private fun viewModelFactory() {
        when (this) {
            is MainFragment -> viewModel = MainViewModel()
        }
    }
}

fun <T : ViewModel> T.createFactory(): ViewModelProvider.Factory {
    val viewModel = this
    return object : ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T = viewModel as T
    }
}