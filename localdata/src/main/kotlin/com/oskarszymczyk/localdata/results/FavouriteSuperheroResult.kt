package com.oskarszymczyk.localdata.results

import com.oskarszymczyk.localdata.applicationdatabase.SuperheroDb

sealed class FavouriteSuperheroResult {
    data class Results(val superheroDb: SuperheroDb): FavouriteSuperheroResult()
    object Empty: FavouriteSuperheroResult()
}