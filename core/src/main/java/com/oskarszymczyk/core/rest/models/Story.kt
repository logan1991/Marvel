package com.oskarszymczyk.core.rest.models

import com.squareup.moshi.Json

data class Story(
        @field:Json(name = "resourceURI") val resourceURI: String?,
        @field:Json(name = "name") val name: String?,
        @field:Json(name = "type") val type: String?
)