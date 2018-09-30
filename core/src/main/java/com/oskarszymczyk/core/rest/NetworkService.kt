package com.oskarszymczyk.core.rest

import com.oskarszymczyk.core.rest.models.base.CharacterDataWrapper
import kotlinx.coroutines.experimental.Deferred
import retrofit2.http.GET
import retrofit2.http.Query

interface NetworkService {

    @GET("/v1/public/characters")
    fun getCharacters(
            @Query("nameStartsWith") startWith: String?,
            @Query("offset") offset: Int?
    ): Deferred<CharacterDataWrapper>
}