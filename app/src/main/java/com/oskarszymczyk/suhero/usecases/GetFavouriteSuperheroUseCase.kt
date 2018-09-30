package com.oskarszymczyk.suhero.usecases

import com.oskarszymczyk.core.rest.NetworkService
import com.oskarszymczyk.suhero.data.SuperheroList
import com.oskarszymczyk.suhero.data.parsers.parseToDomain
import javax.inject.Inject

class GetFavouriteSuperheroUseCase @Inject constructor(private val networkService: NetworkService) {

    suspend fun findFavouriteCharacter(nameStartWith: String, offset: Int): SuperheroList =
            networkService.getCharacters(nameStartWith, offset).await().parseToDomain()
}