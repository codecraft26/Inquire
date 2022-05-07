package dev.aman.inquire.individual.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import dev.aman.inquire.individual.model.User
import java.sql.Timestamp

/*
data class Inquire(
    val id : Int,
    val title:String="",
    val description:String="",
    val upVotes:Int=0,  // number of upvotes
    val  language:String="",
    val timestamp:Long=0,
    val createdBy:User,
    val imageUri:String="",

)
*/
data class Inquire(
    val title: String,
    val description: String,
    //drawable
    @DrawableRes val image: Int,
    @DrawableRes val profile: Int
)

