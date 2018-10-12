package com.oskarszymczyk.suhero.di_components

import com.oskarszymczyk.suhero.ui.welcome.WelcomeActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class WelcomeActivityModule {
    @ContributesAndroidInjector(modules = [FragmentBuildersModule::class])
    abstract fun contributeMainActivity(): WelcomeActivity
}