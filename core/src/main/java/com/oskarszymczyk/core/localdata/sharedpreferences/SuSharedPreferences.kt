package com.oskarszymczyk.core.localdata.sharedpreferences

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import javax.inject.Inject

class SuSharedPreferences @Inject constructor(suApplication: Application){

    private val GENERAL_PREFERENCES_NAME = "application_storage"

    private val SHOW_MAIN_SCREEN = "SHOW_MAIN_SCREEN"

    var appSharedPreferences: SharedPreferences = suApplication.getSharedPreferences(GENERAL_PREFERENCES_NAME, Context.MODE_PRIVATE)

    fun welcomeScreenWasShow(){
        appSharedPreferences.edit().putBoolean(SHOW_MAIN_SCREEN, true).apply()
    }

    fun shouldShowMainScreen(): Boolean  = appSharedPreferences.getBoolean(SHOW_MAIN_SCREEN, false)
}