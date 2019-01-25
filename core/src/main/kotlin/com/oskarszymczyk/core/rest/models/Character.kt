package com.oskarszymczyk.core.rest.models

import com.oskarszymczyk.core.rest.models.base.CollectionBaseResponse
import com.squareup.moshi.Json

data class Character(
        @field:Json(name = "id") val id: Int,
        @field:Json(name = "name") val name: String,
        @field:Json(name = "description") val description: String,
        @field:Json(name = "thumbnail") val image: Image,
        @field:Json(name = "comics") val comicsList: CollectionBaseResponse<Comics>,
        @field:Json(name = "stories") val storiesList: CollectionBaseResponse<Story>,
        @field:Json(name = "events") val eventsList: CollectionBaseResponse<Event>,
        @field:Json(name = "series") val seriesList: CollectionBaseResponse<Series>)


data class Image(
        @field:Json(name = "path") val path: String,
        @field:Json(name = "extension") val extension: String) {

    //todo [UI] different image size
    fun createPath() = path + "/portrait_small." + extension
}
