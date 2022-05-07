package dev.aman.inquire.individual.model

import androidx.room.PrimaryKey

data class User(
    @PrimaryKey(autoGenerate = true)
    val id: String,
    val username:String="",
    val name: String="",
    val email: String="")


