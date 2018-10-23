package com.oskarszymczyk.suhero.di_components

object AppInjector {

    private var appComponent: AppComponent? = null

    fun init(appComponent: AppComponent) {
        this.appComponent = appComponent
    }

    fun getNavigationFactory() = appComponent!!.navigationFactory()

}