package com.oskarszymczyk.suhero.usecases

import javax.inject.Inject

class ListPaginationUseCase @Inject constructor() {
    var totalCount: Int = 0
    var actualCount: Int = 0
        set(value) {
            isDownloadInProgress = false
            field += value
        }
    var isDownloadInProgress = false

    fun execute(function: () -> Unit) {
        if (checkIfDownloadIsNeeded()) {
            isDownloadInProgress = true
            function()
        }
    }

    fun checkIfDownloadIsNeeded() =
            !isDownloadInProgress && totalCount > actualCount

}