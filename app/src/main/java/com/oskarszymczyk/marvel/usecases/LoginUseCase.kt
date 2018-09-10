package com.oskarszymczyk.marvel.usecases

import com.oskarszymczyk.core.rest.NetworkService
import javax.inject.Inject

class LoginUseCase @Inject constructor(private val networkService: NetworkService) {

    fun login() {
        println("TODO")
    }
}