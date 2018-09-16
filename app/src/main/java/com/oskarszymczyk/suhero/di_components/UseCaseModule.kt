package com.oskarszymczyk.suhero.di_components

import com.oskarszymczyk.core.rest.NetworkManager
import com.oskarszymczyk.suhero.usecases.LoginUseCase
import dagger.Binds
import dagger.Module

@Module(includes = [NetworkManager::class])
abstract class UseCaseModule {

    @Binds
    abstract fun provideLoginUseCase(loginUseCase: LoginUseCase): LoginUseCase

}