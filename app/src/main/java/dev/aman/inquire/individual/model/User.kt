package dev.aman.inquire.individual.model

import androidx.room.PrimaryKey

data class User(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val user_name:String,
    val fist_name: String,
    val last_name: String,
    val password: String
)

