package com.oskarszymczyk.localdata.models

import com.oskarszymczyk.localdata.models.Superhero

data class SuperheroList(
        val total: Int,
        val resultCount:Int,
        val data: List<Superhero>)