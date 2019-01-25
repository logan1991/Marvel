package com.oskarszymczyk.localdata

import android.app.Application
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class SharedPreferencesModule {

    @Provides
    @Singleton
    fun providesSuSharedPreferences(suHeroApplication: Application) = SuSharedPreferences(suHeroApplication)

}