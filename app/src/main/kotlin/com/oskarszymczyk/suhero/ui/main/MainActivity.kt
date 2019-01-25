package com.oskarszymczyk.suhero.ui.main

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.View
import com.oskarszymczyk.suhero.R
import com.oskarszymczyk.suhero.databinding.MainActivityBinding
import dagger.android.support.DaggerAppCompatActivity
import dagger.android.support.HasSupportFragmentInjector

class MainActivity : DaggerAppCompatActivity(), HasSupportFragmentInjector {

    lateinit var binding: MainActivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.main_activity)
        setSupportActionBar(binding.mainToolbar)
    }

    fun hideBottomNavigation(){
        binding.bottomNavigation.visibility = View.GONE
    }

    fun showBottomNavigation(){
        binding.bottomNavigation.visibility = View.VISIBLE
    }

}
