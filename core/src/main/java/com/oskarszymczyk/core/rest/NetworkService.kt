package com.oskarszymczyk.core.rest

import com.oskarszymczyk.core.rest.models.Character
import com.oskarszymczyk.core.rest.models.base.BaseResponse
import retrofit2.Call
import retrofit2.http.GET

interface NetworkService {

    @GET("/v1/public/characters")
    fun getCharacters(): Call<BaseResponse<Character>>
}