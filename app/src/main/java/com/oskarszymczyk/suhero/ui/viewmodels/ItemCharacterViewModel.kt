package com.oskarszymczyk.suhero.ui.viewmodels

import android.databinding.ObservableField
import com.oskarszymczyk.suhero.data.Superhero

class ItemCharacterViewModel {
    val heroName: ObservableField<String> = ObservableField()
    val imageUrl: ObservableField<String> = ObservableField()

    fun initView(superhero: Superhero) {
        heroName.set(superhero.name)
        imageUrl.set(superhero.photo)
    }
}