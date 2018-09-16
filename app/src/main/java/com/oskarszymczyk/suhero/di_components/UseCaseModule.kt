package com.oskarszymczyk.marvel.di_components

import com.oskarszymczyk.core.rest.NetworkManager
import com.oskarszymczyk.marvel.usecases.LoginUseCase
import dagger.Binds
import dagger.Module

@Module(includes = [NetworkManager::class])
abstract class UseCaseModule {

    @Binds
    abstract fun provideLoginUseCase(loginUseCase: LoginUseCase): LoginUseCase

}