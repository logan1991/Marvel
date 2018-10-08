package com.oskarszymczyk.suhero.usecases

import com.oskarszymczyk.suhero.repos.SuperheroListRepository
import javax.inject.Inject

class GetSuperheroListUseCase @Inject constructor(private val superheroList: SuperheroListRepository){

    suspend fun execute() =
        superheroList.getNextPage()


}
