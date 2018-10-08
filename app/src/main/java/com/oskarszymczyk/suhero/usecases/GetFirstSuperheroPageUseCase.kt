package com.oskarszymczyk.suhero.usecases

import android.util.Log
import com.oskarszymczyk.suhero.repos.SuperheroListRepository
import javax.inject.Inject

class GetFirstSuperheroPageUseCase @Inject constructor(private val superheroList: SuperheroListRepository) {


    init {
        Log.e(this.javaClass.simpleName, "$superheroList")
    }
    suspend fun execute(nameStartWith: String) =
       superheroList.getList(nameStartWith)

}