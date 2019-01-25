package com.oskarszymczyk.core.rest.models.base

import com.squareup.moshi.Json

data class CollectionBaseResponse<T>(
        @field:Json(name = "available") val available: Int?,
        @field:Json(name = "returned") val returned: Int?,
        @field:Json(name = "collectionURI") val collectionURI: String?,
        @field:Json(name = "items") val items: List<T>)