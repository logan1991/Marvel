package com.oskarszymczyk.marvel.rest.models.base

/**
 * LT - list type
 * T - item type
 * **/
data class BaseResponse<LT>(val data: ProperData<LT>)

data class ProperData<T>(val results: List<T>)