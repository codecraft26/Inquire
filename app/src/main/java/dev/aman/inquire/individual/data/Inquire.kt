package dev.aman.inquire.individual.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Inquire(
    val title: String,
    val description: String,
    //drawable
    @DrawableRes val image: Int,
    @DrawableRes val profile: Int
)

