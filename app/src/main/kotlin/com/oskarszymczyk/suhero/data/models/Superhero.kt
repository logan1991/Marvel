package com.oskarszymczyk.suhero.data.models

import android.os.Parcelable
import com.oskarszymczyk.localdata.applicationdatabase.SuperheroDb
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Superhero(
        val id: Int,
        val name: String?,
        val photo: String?): Parcelable


fun Superhero.parseToDbObject() = SuperheroDb(id, id, name, photo)
