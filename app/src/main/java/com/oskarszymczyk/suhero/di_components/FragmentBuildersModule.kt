package com.oskarszymczyk.suhero.di_components

import com.oskarszymczyk.suhero.ui.splash.SplashFragment
import com.oskarszymczyk.suhero.ui.welcome.WelcomeFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuildersModule {
    @ContributesAndroidInjector
    abstract fun contributeWelcomeFragment(): WelcomeFragment

    @ContributesAndroidInjector
    abstract fun contributeSplashFragment(): SplashFragment
}