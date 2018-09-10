package com.oskarszymczyk.marvel.di_components

import com.oskarszymczyk.marvel.ui.welcome.WelcomeFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuildersModule {
    @ContributesAndroidInjector
    abstract fun contributeWelcomeFragment(): WelcomeFragment
}