package com.oskarszymczyk.suhero.usecases

import android.util.Log
import com.oskarszymczyk.suhero.repos.SuperheroListRepository
import javax.inject.Inject

class GetFirstSuperheroPageUseCase @Inject constructor(private val superheroList: SuperheroListRepository) {

    suspend fun execute(nameStartWith: String) =
       superheroList.getInitData(nameStartWith)
}