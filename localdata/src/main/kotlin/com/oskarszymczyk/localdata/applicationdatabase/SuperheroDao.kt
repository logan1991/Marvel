package com.oskarszymczyk.localdata.applicationdatabase

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query


@Dao
interface SuperheroDao {
   @Query("SELECT * FROM superherodb")
   fun getAllSuperHero(): List<SuperheroDb>


   @Insert
   fun addFavouriteSuperhero(superheroDb: SuperheroDb)
}