package com.oskarszymczyk.suhero.di_components

import com.oskarszymczyk.suhero.NavigationFactory
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    @Singleton
    fun provideNavigationFactory() : NavigationFactory = NavigationFactory()

}