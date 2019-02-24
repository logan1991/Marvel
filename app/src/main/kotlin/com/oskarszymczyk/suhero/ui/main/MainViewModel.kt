package com.oskarszymczyk.suhero.ui.main

import android.arch.lifecycle.ViewModel
import android.databinding.ObservableField
import com.oskarszymczyk.localdata.DatabaseManager
import com.oskarszymczyk.localdata.results.FavouriteSuperheroResult
import com.oskarszymczyk.suhero.data.models.Superhero
import com.oskarszymczyk.suhero.data.parsers.parseToObject
import kotlinx.coroutines.experimental.GlobalScope
import kotlinx.coroutines.experimental.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(private val databaseManager: DatabaseManager) : ViewModel() {

    var text = ObservableField<String>()

    init {
        initData()
    }

    private fun initData() {
        GlobalScope.launch {
            val results = databaseManager.getFavouriteSuperhero()
            when (results) {
                is FavouriteSuperheroResult.Results -> handleFavouriteHero(results.superheroDb.parseToObject())
                is FavouriteSuperheroResult.Empty -> showEmptyView()
            }
        }
    }

    private fun showEmptyView() {
        text.set("TODO : EMPTY")
    }

    fun handleFavouriteHero(superhero: Superhero) {
        text.set("TODO : ${superhero.name}")
    }

}
