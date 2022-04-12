package dev.aman.inquire.individual.model

import androidx.room.PrimaryKey

data class User(
    @PrimaryKey val id: String,
    val name: String = "",
    val photoUrl: String = ""

)