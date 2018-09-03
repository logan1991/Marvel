package com.oskarszymczyk.marvel.rest

import com.oskarszymczyk.marvel.rest.models.Character
import com.oskarszymczyk.marvel.rest.models.base.BaseResponse
import retrofit2.Call
import retrofit2.http.GET

interface NetworkService {

    @GET("/v1/public/characters")
    fun getCharacters(): Call<BaseResponse<Character>>
}