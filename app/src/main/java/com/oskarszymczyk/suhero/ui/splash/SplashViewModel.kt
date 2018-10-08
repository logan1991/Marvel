package com.oskarszymczyk.suhero.ui.splash

import android.arch.lifecycle.ViewModel
import androidx.navigation.NavController
import com.oskarszymczyk.suhero.extensions.getNavController
import com.oskarszymczyk.suhero.usecases.GetFragmentAfterSplashUseCase
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.launch
import javax.inject.Inject

class SplashViewModel @Inject constructor(
        val getFragmentAfterSplashUseCase: GetFragmentAfterSplashUseCase) : ViewModel() {

    val SPLASH_SCREEN_DELAY_TIME_IN_MILLISECONDS = 1000

    lateinit var navController: NavController

    fun changeScreen(){
        navController = getNavController()
        if (getFragmentAfterSplashUseCase.shouldShowMainScreen()) {
            //todo download data for first screen before open main fragment
            navController.navigate(SplashFragmentDirections.openMainFragment())
        } else {
            launch {
                delay(SPLASH_SCREEN_DELAY_TIME_IN_MILLISECONDS)
                navController.navigate(SplashFragmentDirections.openWelcomeFragment())
            }
        }
    }
}