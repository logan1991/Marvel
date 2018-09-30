package com.oskarszymczyk.suhero

import android.support.v4.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment

class NavigationFactory {

    var navController: NavController? = null

    fun getSpecyficNavController() = navController!!

    fun createNavController(fragment: Fragment){
        navController = NavHostFragment.findNavController(fragment)
    }
}