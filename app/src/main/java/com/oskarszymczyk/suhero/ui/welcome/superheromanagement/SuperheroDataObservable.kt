package com.oskarszymczyk.suhero.ui.welcome.superheromanagement

interface SuperheroDataObservable {

    fun addObserver(onSuperheroDataListener: OnSuperheroDataListener)
    fun clearObservers()
    fun notifyObservers(superheroData: SuperheroData)
}