package com.oskarszymczyk.suhero.ui.welcome

import android.arch.lifecycle.ViewModel
import android.databinding.ObservableArrayList
import android.databinding.ObservableBoolean
import android.databinding.ObservableList
import android.util.Log
import com.oskarszymczyk.suhero.data.Superhero
import com.oskarszymczyk.suhero.data.SuperheroResponse
import com.oskarszymczyk.suhero.usecases.GetFirstSuperheroPageUseCase
import com.oskarszymczyk.suhero.usecases.GetSuperheroListUseCase
import com.oskarszymczyk.suhero.utils.DebounceTextWatcher
import kotlinx.coroutines.experimental.Job
import kotlinx.coroutines.experimental.cancelChildren
import kotlinx.coroutines.experimental.launch
import javax.inject.Inject

class WelcomeViewModel @Inject constructor(
        private val getFirstSuperheroPage: GetFirstSuperheroPageUseCase,
        private val getSuperheroList: GetSuperheroListUseCase) : ViewModel() {


    val listData: ObservableList<Superhero> = ObservableArrayList<Superhero>()
    val showScreenProgress = ObservableBoolean(false)

    //nie wiem czy to nie powinno byc Injectowane ?
    private val debounceTextWatcher: DebounceTextWatcher = DebounceTextWatcher()
    private val job = Job()
    private lateinit var lastQuery: String


    fun onTextChanged(userInput: CharSequence) {
        debounceTextWatcher.waitForInputFinished { startDownloadCharacterList(userInput.toString()) }
    }

    private fun startDownloadCharacterList(query: String) {
        if (query.isNotBlank()) {
            showScreenProgress.set(true)
            launch(job){
                lastQuery = query
                listData.clear()
                handleResponse(getFirstSuperheroPage.execute(lastQuery))
            }
        }
    }


    private fun handleResponse(superheroResponse: SuperheroResponse){
        when(superheroResponse){
            is SuperheroResponse.Results -> showData(superheroResponse.superheroList)
            is SuperheroResponse.Error -> showErrorMessage(superheroResponse.errorMessage)
            is SuperheroResponse.NoMoreData -> hideProgressFromList()
            is SuperheroResponse.Empty -> showEmptyView()
        }
    }

    private fun hideProgressFromList() {
        //todo
    }

    fun showData(superheroList: List<Superhero>){
        showScreenProgress.set(false)
        listData.addAll(superheroList)
    }

    fun showEmptyView(){
        //todo
    }

    fun showErrorMessage(message:String){
        //todo
    }

    fun lastItemIsVisible() {
        launch(job) {
            handleResponse(getSuperheroList.execute())
        }
    }

    override fun onCleared() {
        job.cancelChildren()
        super.onCleared()
    }


}