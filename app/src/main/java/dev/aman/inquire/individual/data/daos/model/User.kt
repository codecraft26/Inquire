package dev.aman.inquire.individual.data.daos.model

import androidx.room.PrimaryKey

data class User(
    val id: String,
    val username:String="",
    val name: String="",
    val email: String="")


