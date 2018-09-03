package com.oskarszymczyk.marvel.ui.main

import android.databinding.ObservableField
import com.oskarszymczyk.marvel.base.BaseViewModel
import com.oskarszymczyk.marvel.rest.NetworkService
import com.oskarszymczyk.marvel.rest.models.Character
import com.oskarszymczyk.marvel.rest.models.base.BaseResponse
import retrofit2.Call
import retrofit2.Response
import javax.inject.Inject

class MainViewModel : BaseViewModel() {

    @Inject
    lateinit var networkService: NetworkService

    var text = ObservableField<String>()

    init {
        networkService.getCharacters().enqueue(object : retrofit2.Callback<BaseResponse<Character>> {
            override fun onFailure(call: Call<BaseResponse<Character>>, t: Throwable) {
                text.set(t.message.orEmpty())
            }

            override fun onResponse(call: Call<BaseResponse<Character>>, response: Response<BaseResponse<Character>>) {
                if (response.isSuccessful) {
                    text.set("Success, listSize : " + response.body()?.data?.results?.size)
                } else {
                    text.set("Fail")
                }
            }
        })
    }


}
