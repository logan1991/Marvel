package com.oskarszymczyk.suhero.ui.viewdatas

import android.databinding.ObservableBoolean
import android.databinding.ObservableField
import android.view.View
import com.oskarszymczyk.suhero.data.Superhero
import com.oskarszymczyk.suhero.ui.welcome.superheromanagement.SelectedSuperheroManger

class ItemCharacterViewData(val selectedSuperheroManger: SelectedSuperheroManger) {
    val heroName: ObservableField<String> = ObservableField()
    val imageUrl: ObservableField<String> = ObservableField()
    val isSelected: ObservableBoolean = ObservableBoolean(false)
    lateinit var superhero: Superhero
    var position: Int = 0

    fun initView(superhero: Superhero, position: Int) {
        this.superhero = superhero
        this.position = position
        heroName.set(superhero.name)
        imageUrl.set(superhero.photo)
    }

    fun refreshBackground(isSelected: Boolean) {
        this.isSelected.set(isSelected)
    }

    fun onSuperheroClicked(view: View) {
        selectedSuperheroManger.dataChange(superhero, position)
    }
}