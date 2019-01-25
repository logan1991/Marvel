package com.oskarszymczyk.suhero.di_components

import com.oskarszymczyk.suhero.di_components.fragment.FragmentModule
import com.oskarszymczyk.suhero.di_components.fragment.FragmentScope
import com.oskarszymczyk.suhero.ui.main.MainFragment
import com.oskarszymczyk.suhero.ui.splash.SplashFragment
import com.oskarszymczyk.suhero.ui.welcome.WelcomeFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuildersModule {
    @ContributesAndroidInjector(modules = [FragmentModule::class, ViewModelModule::class])
    @FragmentScope
    abstract fun contributeWelcomeFragment(): WelcomeFragment


    @ContributesAndroidInjector(modules = [ViewModelModule::class])
    @FragmentScope
    abstract fun contributeSplashFragment(): SplashFragment

    @ContributesAndroidInjector(modules = [ViewModelModule::class])
    @FragmentScope
    abstract fun contributeMainFragment(): MainFragment

}