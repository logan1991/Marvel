package com.oskarszymczyk.suhero.ui.welcome

import android.arch.lifecycle.ViewModel
import com.oskarszymczyk.suhero.usecases.LoginUseCase
import javax.inject.Inject

class WelcomeViewModel @Inject constructor(loginUseCase: LoginUseCase) : ViewModel() {

    init {
        throw RuntimeException("TestCrash")
        loginUseCase.login()
    }
}
