package com.oskarszymczyk.suhero.data

sealed class SuperheroResponse {
    data class Results(val superheroList: List<Superhero>): SuperheroResponse()
    data class Error(val errorMessage: String): SuperheroResponse()
    object NoMoreData: SuperheroResponse()
    object Empty : SuperheroResponse()
}