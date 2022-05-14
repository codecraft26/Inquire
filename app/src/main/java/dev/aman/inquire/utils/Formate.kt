package dev.aman.inquire.utils

import java.text.SimpleDateFormat
import java.util.*

fun getFormattedDateTime(): String = run {
    SimpleDateFormat("dd/MM/yy hh:mm aaa", Locale.ENGLISH).format(System.currentTimeMillis())
}

fun getUuid() = UUID.randomUUID().toString()

fun getUniqueNameForImage() = "${getUuid()} ${getFormattedDateTime()}"
