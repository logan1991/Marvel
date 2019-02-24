package com.oskarszymczyk.suhero.data.models

data class SuperheroList(
        val total: Int,
        val resultCount:Int,
        val data: List<Superhero>)