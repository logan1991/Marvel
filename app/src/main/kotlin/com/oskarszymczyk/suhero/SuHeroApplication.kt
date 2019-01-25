package com.oskarszymczyk.suhero

import android.app.Activity
import android.app.Application
import com.crashlytics.android.Crashlytics
import com.oskarszymczyk.suhero.di_components.AppInjector
import com.oskarszymczyk.suhero.di_components.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import io.fabric.sdk.android.Fabric
import javax.inject.Inject

class SuHeroApplication : DaggerApplication(), HasActivityInjector {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        val appComponent = DaggerAppComponent.builder().application(this).build()
        AppInjector.init(appComponent)
        return appComponent
    }

    override fun onCreate() {
        super.onCreate()
        Fabric.with(this, Crashlytics())
    }
}