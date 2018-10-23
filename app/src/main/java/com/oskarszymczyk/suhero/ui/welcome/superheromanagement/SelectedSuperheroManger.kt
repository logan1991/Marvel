package com.oskarszymczyk.suhero.ui.welcome.superheromanagement

import com.oskarszymczyk.suhero.data.Superhero

class SelectedSuperheroManger : SuperheroDataObservable {

    val observersList = mutableListOf<OnSuperheroDataListener>()
    //init value
    private var oldSelectedPosition = -1


    override fun addObserver(onSuperheroDataListener: OnSuperheroDataListener) {
        if(!observersList.contains(onSuperheroDataListener)){
            observersList.add(onSuperheroDataListener)
        }
    }

    override fun clearObservers() {
        observersList.clear()
    }

    override fun notifyObservers(superheroData: SuperheroData) {
        observersList.forEach { it.updateValue(superheroData) }
    }

    fun dataChange(superhero: Superhero, position:Int){
        if(oldSelectedPosition != position){
            notifyObservers(SuperheroData(superhero, position))
            oldSelectedPosition = position
        }
    }
}