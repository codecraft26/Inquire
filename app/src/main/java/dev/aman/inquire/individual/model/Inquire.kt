package dev.aman.inquire.individual.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes


data   class Inquire(
     val stringResourceId: String="",
   val descriptionResourceId: String="",
    @DrawableRes val imageResourceId: Int
 )