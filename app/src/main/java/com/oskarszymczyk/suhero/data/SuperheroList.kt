package com.oskarszymczyk.suhero.data

data class SuperheroList(
        val total: Int,
        val resultCount:Int,
        val data: List<Superhero>)