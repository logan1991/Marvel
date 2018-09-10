package com.oskarszymczyk.marvel.usecases

import dagger.Module
import dagger.Provides

@Module(includes = [
    UseCasesModule.Login::class])
@Suppress("unused")
class UseCasesModule {

    @Module
    class Login {
        @Provides
        fun provideLoginUseCase(useCase: LoginUseCase): LoginUseCase = useCase
    }
}