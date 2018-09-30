package com.oskarszymczyk.core.rest.models.base

import com.oskarszymczyk.core.rest.models.Character
import com.squareup.moshi.Json

data class CharacterDataWrapper(
        @field:Json(name = "data") val characterDataContainer: CharacterDataContainer

)

data class CharacterDataContainer(
        @field:Json(name = "total") val totalResults: Int?,
        @field:Json(name = "results") val characterList: List<Character>
)

