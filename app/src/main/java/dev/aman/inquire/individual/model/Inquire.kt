package dev.aman.inquire.individual.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes


data   class Inquire(
    val id: String,
    val title: String,
    val language: String,
    val description: String,
    val tags: List<String>,
    val imageUrl: String?,
    val code: String?

 )