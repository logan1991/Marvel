package com.oskarszymczyk.suhero.ui.splash

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.oskarszymczyk.suhero.R
import com.oskarszymczyk.suhero.base.Injectable
import com.oskarszymczyk.suhero.databinding.SplashFragmentBinding
import com.oskarszymczyk.suhero.extensions.hideToolbar
import com.oskarszymczyk.suhero.extensions.setNavController
import com.oskarszymczyk.suhero.extensions.viewModelDelegate

class SplashFragment : Fragment(), Injectable {

    private val viewModel: SplashViewModel by viewModelDelegate()

    private lateinit var splashFragmentBinding: SplashFragmentBinding


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        hideToolbar()
        splashFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.splash_fragment, container, false)
        setNavController()
        return splashFragmentBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        splashFragmentBinding.viewModel = viewModel
    }
}
