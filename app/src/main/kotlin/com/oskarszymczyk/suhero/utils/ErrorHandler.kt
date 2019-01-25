package com.oskarszymczyk.suhero.utils

import java.net.SocketTimeoutException

object ErrorHandler {

    fun getErrorMessage(exp: Exception): String{
        return when (exp){

            is SocketTimeoutException -> "Timeout :("

            else -> "Ups, Something went wrong :D"
        }
    }
}