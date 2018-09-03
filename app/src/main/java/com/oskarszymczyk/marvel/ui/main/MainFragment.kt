package com.oskarszymczyk.marvel.ui.main

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.oskarszymczyk.marvel.R
import com.oskarszymczyk.marvel.base.BaseFragment
import com.oskarszymczyk.marvel.databinding.MainFragmentBinding


class MainFragment : BaseFragment<MainViewModel>() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var fragmentBinding: MainFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        fragmentBinding = DataBindingUtil.inflate(inflater, R.layout.main_fragment, container, false)
        fragmentBinding.viewModel = viewModel
        return fragmentBinding.root
    }
}