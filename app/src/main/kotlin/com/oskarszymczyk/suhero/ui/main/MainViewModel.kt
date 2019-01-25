package com.oskarszymczyk.suhero.ui.main

import android.arch.lifecycle.ViewModel
import android.databinding.ObservableField
import com.oskarszymczyk.localdata.models.Superhero
import javax.inject.Inject

class MainViewModel @Inject constructor(): ViewModel() {

    var text = ObservableField<String>()

    init {

    }

    fun passAdditionalData(superhero: Superhero?){
        text.set("Your chosen superhero : ${superhero?.name}")
    }
}
