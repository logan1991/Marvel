package com.oskarszymczyk.suhero.usecases

import com.oskarszymczyk.localdata.SuSharedPreferences
import javax.inject.Inject

class DisableWelcomeScreenUseCase @Inject constructor(private val sharedPreferences: SuSharedPreferences) {

    fun execute() {
        sharedPreferences.welcomeScreenWasShow();
    }
}