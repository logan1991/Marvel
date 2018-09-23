package com.oskarszymczyk.suhero

import android.app.Activity
import android.app.Application
import com.crashlytics.android.Crashlytics
import com.oskarszymczyk.suhero.di_components.AppInjector
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import io.fabric.sdk.android.Fabric
import javax.inject.Inject

class SuHeroApplication : Application(), HasActivityInjector {
    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    override fun activityInjector(): AndroidInjector<Activity> = dispatchingAndroidInjector

    override fun onCreate() {
        super.onCreate()
        AppInjector.init(this)
        Fabric.with(this, Crashlytics())
    }
}