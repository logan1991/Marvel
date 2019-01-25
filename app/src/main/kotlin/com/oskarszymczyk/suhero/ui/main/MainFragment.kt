package com.oskarszymczyk.suhero.ui.main

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.oskarszymczyk.suhero.R
import com.oskarszymczyk.suhero.databinding.MainFragmentBinding
import com.oskarszymczyk.suhero.extensions.setNavController
import dagger.android.support.DaggerFragment

import javax.inject.Inject


class MainFragment : DaggerFragment() {

    @Inject
    lateinit var mainViewModel: MainViewModel

    private lateinit var fragmentBinding: MainFragmentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setNavController()
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        fragmentBinding = DataBindingUtil.inflate(inflater, R.layout.main_fragment, container, false)

        fragmentBinding.viewModel = mainViewModel

        mainViewModel.passAdditionalData(MainFragmentArgs.fromBundle(arguments).superhero)

        return fragmentBinding.root
    }
}