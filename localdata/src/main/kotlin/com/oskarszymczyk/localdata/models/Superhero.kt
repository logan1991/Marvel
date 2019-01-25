package com.oskarszymczyk.localdata.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Superhero(
        val id: Int,
        val name: String,
        val photo: String): Parcelable