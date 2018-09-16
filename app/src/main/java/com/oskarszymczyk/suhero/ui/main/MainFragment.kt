package com.oskarszymczyk.marvel.ui.main

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.oskarszymczyk.suhero.R
import com.oskarszymczyk.suhero.databinding.MainFragmentBinding


class MainFragment : Fragment() {


    private lateinit var fragmentBinding: MainFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        fragmentBinding = DataBindingUtil.inflate(inflater, R.layout.main_fragment, container, false)

        return fragmentBinding.root
    }
}