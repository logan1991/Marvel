package com.oskarszymczyk.suhero

import android.support.v4.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment

class NavigationFactory {

    lateinit var navController: NavController

    fun createNavController(fragment: Fragment){
        navController = NavHostFragment.findNavController(fragment)
    }
}