package com.oskarszymczyk.localdata

import com.oskarszymczyk.localdata.applicationdatabase.MarvelDatabase
import com.oskarszymczyk.localdata.applicationdatabase.SuperheroDb
import com.oskarszymczyk.localdata.results.FavouriteSuperheroResult
import kotlinx.coroutines.experimental.Dispatchers
import kotlinx.coroutines.experimental.GlobalScope
import kotlinx.coroutines.experimental.launch
import kotlinx.coroutines.experimental.withContext
import java.lang.Exception
import javax.inject.Inject

class DatabaseManager @Inject constructor(private val marvelDatabase: MarvelDatabase) {

    fun saveFavouriteHero(superheroDb: SuperheroDb) {
        GlobalScope.launch(Dispatchers.IO) {
            marvelDatabase.getSuperHero().addFavouriteSuperhero(superheroDb)
        }
    }

    suspend fun getFavouriteSuperhero():FavouriteSuperheroResult {
        return try{
            val superhero = withContext(GlobalScope.coroutineContext) { marvelDatabase.getSuperHero().getAllSuperHero()[0] }
            FavouriteSuperheroResult.Results(superhero)

        }catch (exp: Exception){
            FavouriteSuperheroResult.Empty
        }
    }
}