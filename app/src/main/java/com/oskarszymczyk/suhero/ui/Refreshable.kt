package com.oskarszymczyk.suhero.ui

interface Refreshable {
    fun <T> refreshData(data: List<T>)
}