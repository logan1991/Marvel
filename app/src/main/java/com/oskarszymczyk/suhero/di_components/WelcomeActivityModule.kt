package com.oskarszymczyk.marvel.di_components

import com.oskarszymczyk.marvel.ui.welcome.WelcomeActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class WelcomeActivityModule {
    @ContributesAndroidInjector(modules = [FragmentBuildersModule::class])
    abstract fun contributeMainActivity(): WelcomeActivity
}