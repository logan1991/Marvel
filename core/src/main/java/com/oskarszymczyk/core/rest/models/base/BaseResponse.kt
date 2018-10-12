package com.oskarszymczyk.core.rest.models.base

/**
 * LT - list type
 * T - item type
 * **/
data class BaseResponse<LT>(val code: Int, val data: ProperData<LT>)

data class ProperData<T>(val count: Int, val results: List<T>)