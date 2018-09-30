package com.oskarszymczyk.suhero.di_components

import android.app.Activity
import android.app.Application
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.support.v4.app.FragmentManager
import com.oskarszymczyk.suhero.SuHeroApplication
import com.oskarszymczyk.suhero.base.Injectable
import dagger.android.AndroidInjection
import dagger.android.support.AndroidSupportInjection
import dagger.android.support.HasSupportFragmentInjector

object AppInjector {

    private var appComponent: AppComponent? = null

    fun init(suHeroApplication: SuHeroApplication) {
        appComponent = DaggerAppComponent.builder()
                .application(suHeroApplication)
                .build()
        appComponent!!.inject(suHeroApplication)

        suHeroApplication.registerActivityLifecycleCallbacks(object : Application.ActivityLifecycleCallbacks {
            override fun onActivitySaveInstanceState(activity: Activity?, p1: Bundle?) {
            }

            override fun onActivityStopped(activity: Activity?) {
            }

            override fun onActivityPaused(activity: Activity?) {
            }

            override fun onActivityResumed(activity: Activity?) {
            }

            override fun onActivityStarted(activity: Activity?) {
            }

            override fun onActivityDestroyed(activity: Activity?) {
            }


            override fun onActivityCreated(activity: Activity, bundle: Bundle?) {
                handleActivity(activity)
            }
        })
    }

    fun getViewModelFactory() = appComponent!!.viewModelFactory()

    fun getNavigationFactory() = appComponent!!.navigationFactory()


    private fun handleActivity(activity: Activity) {
        if (activity is HasSupportFragmentInjector) {
            AndroidInjection.inject(activity)
        }
        if (activity is FragmentActivity) {
            activity.supportFragmentManager
                    .registerFragmentLifecycleCallbacks(object : FragmentManager.FragmentLifecycleCallbacks() {
                        override fun onFragmentCreated(fm: FragmentManager, f: Fragment, savedInstanceState: Bundle?) {
                            if (f is Injectable) {
                                AndroidSupportInjection.inject(f)
                            }
                        }
                    }, true)
        }
    }
}