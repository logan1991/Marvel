package com.oskarszymczyk.suhero.usecases

import com.oskarszymczyk.localdata.SuSharedPreferences
import javax.inject.Inject

class GetFragmentAfterSplashUseCase @Inject constructor(private val sharedPreferences: SuSharedPreferences) {
    fun shouldShowMainScreen(): Boolean {
        return sharedPreferences.shouldShowMainScreen()
    }
}