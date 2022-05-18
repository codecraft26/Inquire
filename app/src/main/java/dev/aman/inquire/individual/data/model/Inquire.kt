package dev.aman.inquire.individual.data.model

import android.net.Uri
import dev.aman.inquire.utils.InquireState

data class Inquire(
    var title: String = "",
    val description: String = "",
    val inquire_code: String = "",
    val language: String = "",

    val imageUri: String? = null,
    var status: InquireState = InquireState.UnBookmarked,
    var UpVotes: Int = 0,

    )