package com.oskarszymczyk.suhero.ui.splash

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.oskarszymczyk.suhero.R
import com.oskarszymczyk.suhero.base.Injectable
import com.oskarszymczyk.suhero.databinding.SplashFragmentBinding
import com.oskarszymczyk.suhero.extensions.hideToolbar
import com.oskarszymczyk.suhero.extensions.setNavController
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class SplashFragment : DaggerFragment(), Injectable {

    @Inject
    lateinit var viewModel: SplashViewModel


    private lateinit var splashFragmentBinding: SplashFragmentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setNavController()
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {


        hideToolbar()
        splashFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.splash_fragment, container, false)

        splashFragmentBinding.viewModel = viewModel

        viewModel.changeScreen()
        return splashFragmentBinding.root
    }

}
