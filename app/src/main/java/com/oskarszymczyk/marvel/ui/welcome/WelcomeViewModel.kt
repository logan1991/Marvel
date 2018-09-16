package com.oskarszymczyk.marvel.ui.welcome

import android.arch.lifecycle.ViewModel
import com.oskarszymczyk.marvel.usecases.LoginUseCase
import javax.inject.Inject

class WelcomeViewModel @Inject constructor(loginUseCase: LoginUseCase) : ViewModel() {

    init {
        throw RuntimeException("TestCrash")
        loginUseCase.login()
    }
}
