package dev.aman.inquire.individual.data.daos.model

import android.net.Uri
import dev.aman.inquire.utils.InquireState

data class Inquire(
    val title:String="",
    val description:String="",
    val inquire_code:String="",
    val language:String="",
    val imageUrl: Uri? = null,
    val timestamp: String? = null,
    var status: InquireState = InquireState.UnBookmarked,
    var UpVotes:Int=0,

    )

