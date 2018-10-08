package com.oskarszymczyk.suhero.repos

import com.oskarszymczyk.core.rest.NetworkService
import com.oskarszymczyk.suhero.data.SuperheroResponse
import com.oskarszymczyk.suhero.data.parsers.parseToDomain

//nazwa tutaj scierwi
class SuperheroListRepository(private val networkService: NetworkService) {

    private var offset = 0
        set(value) {
            if (value != 0) {
                field += value
            } else {
                field = 0
            }
        }

    var totalCount: Int = 0

    lateinit var nameStartWith: String

    suspend fun getList(nameStartWith: String): SuperheroResponse {
        offset = 0
        this.nameStartWith = nameStartWith
        return try {
            val results = networkService.getCharacters(nameStartWith, offset).await().parseToDomain()
            if (results.data.isEmpty()) {
                SuperheroResponse.Empty
            } else {
                totalCount = results.total
                offset = results.resultCount
                SuperheroResponse.Results(results.data)
            }
        }catch (exp: Exception){
            //todo error handling
            SuperheroResponse.Error("Example Error Message")
        }

    }

    suspend fun getNextPage(): SuperheroResponse {
        return try {
            if (offset < totalCount) {
                val results = networkService.getCharacters(nameStartWith, offset).await().parseToDomain()
                offset = results.resultCount
                SuperheroResponse.Results(results.data)
            } else {
                SuperheroResponse.NoMoreData
            }
        }catch (exp: Exception){
            //todo error handling
            SuperheroResponse.Error("Example Error Message")
        }
    }
}