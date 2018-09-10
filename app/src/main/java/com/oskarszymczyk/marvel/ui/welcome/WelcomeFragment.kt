package com.oskarszymczyk.marvel.ui.welcome

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.oskarszymczyk.marvel.R
import com.oskarszymczyk.marvel.base.Injectable
import com.oskarszymczyk.marvel.databinding.WelcomeFragmentBinding
import javax.inject.Inject


class WelcomeFragment : Fragment(), Injectable {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    lateinit var welcomeViewModel: WelcomeViewModel


    private lateinit var welcomeFragmentBinding: WelcomeFragmentBinding


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        welcomeFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.welcome_fragment, container, false)


        return welcomeFragmentBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        welcomeViewModel = ViewModelProviders.of(this, viewModelFactory).get(WelcomeViewModel::class.java)

    }

}
