package com.oskarszymczyk.suhero

import android.support.v4.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.oskarszymczyk.suhero.ui.main.MainActivity
import com.oskarszymczyk.suhero.ui.main.MainFragment

class NavigationFactory {

    lateinit var navController: NavController
    val fragmentsWithBottomNavigation: List<String> = listOf(MainFragment::class.java.simpleName)

    fun createNavController(fragment: Fragment){
        navController = NavHostFragment.findNavController(fragment)
        showShowBottomNavigation(fragment)
    }

    fun showShowBottomNavigation(fragment: Fragment){
        if(fragmentsWithBottomNavigation.contains(fragment::class.java.simpleName) &&
                fragment.activity is MainActivity){
            (fragment.activity as MainActivity).showBottomNavigation()
        }else{
            (fragment.activity as MainActivity).hideBottomNavigation()
        }
    }
}