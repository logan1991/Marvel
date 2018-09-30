package com.oskarszymczyk.suhero.ui.welcome

import android.arch.lifecycle.ViewModel
import android.databinding.ObservableArrayList
import android.databinding.ObservableList
import com.oskarszymczyk.suhero.data.Superhero
import com.oskarszymczyk.suhero.usecases.GetFavouriteSuperheroUseCase
import com.oskarszymczyk.suhero.usecases.ListPaginationUseCase
import com.oskarszymczyk.suhero.usecases.TimerAfterInputUseCase
import kotlinx.coroutines.experimental.launch
import javax.inject.Inject

class WelcomeViewModel @Inject constructor(
        private val getFavouriteSuperheroUseCase: GetFavouriteSuperheroUseCase,
        private val timerAfterInputUseCase: TimerAfterInputUseCase,
        private val listPaginationUseCase: ListPaginationUseCase) : ViewModel() {

    val listData: ObservableList<Superhero> = ObservableArrayList()
    private lateinit var currentQuery: String

    fun onTextChanged(userInput: CharSequence) {
        timerAfterInputUseCase.waitForInputFinished { startDownloadCharacterList(userInput.toString()) }
    }


    private fun startDownloadCharacterList(query: String) {
        if (query.isNotBlank()) {
            getCharacters(query, 0)
        }
    }

    private fun getCharacters(query: String, offset: Int) {
        launch {
            currentQuery = query
            val results = getFavouriteSuperheroUseCase.findFavouriteCharacter(query, offset)
            if (results.total != null) {
                listPaginationUseCase.totalCount = results.total
            }
            listPaginationUseCase.actualCount = results.data.size
            resetResultsWhenNewQuery(offset)
            listData.addAll(results.data)
        }
    }

    private fun resetResultsWhenNewQuery(offset: Int) {
        if (offset == 0) {
            listData.clear()
        }
    }

    fun lastItemIsVisible() {
        listPaginationUseCase.execute { getCharacters(currentQuery, listPaginationUseCase.actualCount) }
    }
}