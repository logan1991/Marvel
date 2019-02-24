package com.oskarszymczyk.localdata.applicationdatabase

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase


@Database(entities = arrayOf(SuperheroDb::class), version = 1)
abstract class MarvelDatabase: RoomDatabase() {
    abstract fun getSuperHero(): SuperheroDao
}