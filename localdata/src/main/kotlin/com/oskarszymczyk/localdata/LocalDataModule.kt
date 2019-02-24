package com.oskarszymczyk.localdata

import android.app.Application
import android.arch.persistence.room.Room
import com.oskarszymczyk.localdata.applicationdatabase.MarvelDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDataModule {


    @Provides
    @Singleton
    fun providesSuSharedPreferences(suHeroApplication: Application) = SuSharedPreferences(suHeroApplication)

    @Provides
    @Singleton
    fun providesMarvelDatabase(suHeroApplication: Application): MarvelDatabase{
        val database = Room.databaseBuilder(
                        suHeroApplication,
                        MarvelDatabase::class.java, "database-name").build()

        return database
    }

    @Provides
    @Singleton
    fun providesDatabaseManager(marvelDatabase: MarvelDatabase) = DatabaseManager(marvelDatabase)

}