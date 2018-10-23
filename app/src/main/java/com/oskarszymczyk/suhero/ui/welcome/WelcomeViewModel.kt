package com.oskarszymczyk.suhero.ui.welcome

import android.arch.lifecycle.ViewModel
import android.databinding.ObservableArrayList
import android.databinding.ObservableBoolean
import android.databinding.ObservableField
import android.databinding.ObservableList
import com.oskarszymczyk.suhero.data.Superhero
import com.oskarszymczyk.suhero.data.SuperheroResponse
import com.oskarszymczyk.suhero.ui.welcome.superheromanagement.OnSuperheroDataListener
import com.oskarszymczyk.suhero.usecases.GetFirstSuperheroPageUseCase
import com.oskarszymczyk.suhero.usecases.GetSuperheroListUseCase
import com.oskarszymczyk.suhero.ui.welcome.superheromanagement.SelectedSuperheroManger
import com.oskarszymczyk.suhero.ui.welcome.superheromanagement.SuperheroData
import com.oskarszymczyk.suhero.utils.UserInputCallback
import kotlinx.coroutines.experimental.*
import java.util.*
import javax.inject.Inject


class WelcomeViewModel @Inject constructor(
        private val getFirstSuperheroPage: GetFirstSuperheroPageUseCase,
        private val getSuperheroList: GetSuperheroListUseCase,
        private val userInputCallback: UserInputCallback,
        private val selectedSuperheroManger: SelectedSuperheroManger)
    : ViewModel(), OnSuperheroDataListener {


    val listData: ObservableList<Superhero> = ObservableArrayList<Superhero>()
    val showScreenProgress = ObservableBoolean(false)
    val chooseButtonEnable = ObservableBoolean(false)

    val job = Job()
    private lateinit var lastQuery: String

    lateinit var noMoreData: () -> Unit
    lateinit var resetAdapterData:() -> Unit
    lateinit var showToast: (String) -> Unit

    init {
        selectedSuperheroManger.addObserver(this)
    }

    override fun updateValue(superheroData: SuperheroData) {
        chooseButtonEnable.set(true)
    }

    fun onTextChanged(userInput: CharSequence) {
        userInputCallback.waitForInputFinished { startDownloadCharacterList(userInput.toString()) }
    }

    private fun startDownloadCharacterList(query: String) {
        if (query.isNotBlank()) {
            showScreenProgress.set(true)
            lastQuery = query
            listData.clear()
            resetAdapterData()
            chooseButtonEnable.set(false)
            GlobalScope.launch(Dispatchers.Main + job){
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
        noMoreData()
    }

    fun showData(superheroList: List<Superhero>){
        showScreenProgress.set(false)
        listData.addAll(superheroList)
    }

    fun showEmptyView(){
        //todo
    }

    fun showErrorMessage(message:String){
        showScreenProgress.set(false)
        showToast(message)
    }

    fun lastItemIsVisible() {
        GlobalScope.launch(Dispatchers.Main + job) {
            handleResponse(getSuperheroList.execute())
        }
    }

    override fun onCleared() {
        job.cancel()
        super.onCleared()
    }
}