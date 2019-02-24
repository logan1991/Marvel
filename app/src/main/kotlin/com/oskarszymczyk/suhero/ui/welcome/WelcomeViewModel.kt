package com.oskarszymczyk.suhero.ui.welcome

import android.arch.lifecycle.ViewModel
import android.databinding.ObservableArrayList
import android.databinding.ObservableBoolean
import android.databinding.ObservableList
import android.view.View
import com.oskarszymczyk.localdata.DatabaseManager
import com.oskarszymczyk.suhero.data.models.Superhero
import com.oskarszymczyk.suhero.data.models.SuperheroResponse
import com.oskarszymczyk.suhero.data.models.parseToDbObject
import com.oskarszymczyk.suhero.extensions.getNavController
import com.oskarszymczyk.suhero.ui.welcome.superheromanagement.OnSuperheroDataListener
import com.oskarszymczyk.suhero.usecases.GetFirstSuperheroPageUseCase
import com.oskarszymczyk.suhero.usecases.GetSuperheroListUseCase
import com.oskarszymczyk.suhero.ui.welcome.superheromanagement.SelectedSuperheroManger
import com.oskarszymczyk.suhero.ui.welcome.superheromanagement.SuperheroData
import com.oskarszymczyk.suhero.utils.UserInputCallback
import kotlinx.coroutines.experimental.*
import javax.inject.Inject


class WelcomeViewModel @Inject constructor(
        private val databaseManager: DatabaseManager,
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
    lateinit var choosenSuperhero: Superhero

    init {
        selectedSuperheroManger.addObserver(this)
    }

    override fun updateValue(superheroData: SuperheroData) {
        chooseButtonEnable.set(true)
        choosenSuperhero = superheroData.superhero
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

    fun skipToMainFragment(view: View){
        val action = WelcomeFragmentDirections.openMainFragment()
        getNavController().navigate(action)
    }

    fun openMainFragmentWithSuperhero(view: View){
        databaseManager.saveFavouriteHero(choosenSuperhero.parseToDbObject())
        val action = WelcomeFragmentDirections.openMainFragment()
        getNavController().navigate(action)
    }

    override fun onCleared() {
        job.cancel()
        super.onCleared()
    }

}