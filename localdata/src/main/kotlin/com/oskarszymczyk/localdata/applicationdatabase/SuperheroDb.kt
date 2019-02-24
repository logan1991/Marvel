package com.oskarszymczyk.localdata.applicationdatabase

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity
data class SuperheroDb(
        @PrimaryKey
        var uid: Int,
        var id: Int,
        var name: String?,
        var photo: String?
)

