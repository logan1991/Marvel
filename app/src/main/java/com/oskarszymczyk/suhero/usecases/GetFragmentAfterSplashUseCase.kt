package com.oskarszymczyk.suhero.usecases

import com.oskarszymczyk.core.localdata.sharedpreferences.SuSharedPreferences
import javax.inject.Inject

class GetFragmentAfterSplashUseCase @Inject constructor(private val sharedPreferences: SuSharedPreferences) {
    fun shouldShowMainScreen(): Boolean {
        return sharedPreferences.shouldShowMainScreen()
    }
}