package com.oskarszymczyk.suhero.ui.splash

import android.arch.lifecycle.ViewModel
import com.oskarszymczyk.suhero.extensions.getNavController
import com.oskarszymczyk.suhero.usecases.GetFragmentAfterSplashUseCase
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.launch
import javax.inject.Inject

class SplashViewModel @Inject constructor(getFragmentAfterSplashUseCase: GetFragmentAfterSplashUseCase) : ViewModel() {

    val SPLASH_SCREEN_DELAY_TIME_IS_MILLISECONDS = 1000

    private val navController = getNavController()

    init {
        if (getFragmentAfterSplashUseCase.shouldShowMainScreen()) {
            //todo download data for first screen before open main fragment
            navController.navigate(SplashFragmentDirections.openMainFragment())
        } else {
            launch {
                delay(SPLASH_SCREEN_DELAY_TIME_IS_MILLISECONDS)
                navController.navigate(SplashFragmentDirections.openWelcomeFragment())
            }
        }
    }
}
