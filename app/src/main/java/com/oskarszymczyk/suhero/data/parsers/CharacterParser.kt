package com.oskarszymczyk.suhero.data.parsers

import com.oskarszymczyk.core.rest.models.Character
import com.oskarszymczyk.core.rest.models.base.CharacterDataWrapper
import com.oskarszymczyk.suhero.data.Superhero
import com.oskarszymczyk.suhero.data.SuperheroList

fun CharacterDataWrapper.parseToDomain(): SuperheroList {
    val totalResults = if (this.characterDataContainer.totalResults == null) 0 else this.characterDataContainer.totalResults!!
    val resultCount = if (this.characterDataContainer.countResults == null) 0 else this.characterDataContainer.countResults!!
    return SuperheroList(totalResults, resultCount, this.characterDataContainer.characterList.map { it.parseToDomain() })
}

fun Character.parseToDomain(): Superhero {
    return Superhero(this.name, this.image.createPath())
}