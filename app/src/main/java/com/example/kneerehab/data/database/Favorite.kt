
package com.example.kneerehab.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favorites")
data class Favorite(

    @PrimaryKey
    val injuryId: Int,

    val injuryName: String
)
