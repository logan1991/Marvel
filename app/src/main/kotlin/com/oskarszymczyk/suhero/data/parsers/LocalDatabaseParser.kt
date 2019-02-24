package com.oskarszymczyk.suhero.data.parsers

import com.oskarszymczyk.localdata.applicationdatabase.SuperheroDb
import com.oskarszymczyk.suhero.data.models.Superhero

fun SuperheroDb.parseToObject() = Superhero(id, name, photo)