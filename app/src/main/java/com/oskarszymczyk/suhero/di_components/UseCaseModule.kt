package com.oskarszymczyk.suhero.di_components

import com.oskarszymczyk.core.rest.NetworkModule
import com.oskarszymczyk.suhero.usecases.LoginUseCase
import dagger.Binds
import dagger.Module

@Module(includes = [NetworkModule::class])
abstract class UseCaseModule {

    @Binds
    abstract fun provideLoginUseCase(loginUseCase: LoginUseCase): LoginUseCase

}