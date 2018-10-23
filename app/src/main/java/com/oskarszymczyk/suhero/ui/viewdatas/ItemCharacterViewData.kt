package com.oskarszymczyk.suhero.ui.viewdatas

import android.databinding.ObservableField
import com.oskarszymczyk.suhero.data.Superhero

class ItemCharacterViewData {
    val heroName: ObservableField<String> = ObservableField()
    val imageUrl: ObservableField<String> = ObservableField()

    fun initView(superhero: Superhero) {
        heroName.set(superhero.name)
        imageUrl.set(superhero.photo)
    }
}