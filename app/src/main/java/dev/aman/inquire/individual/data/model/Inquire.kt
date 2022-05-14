package dev.aman.inquire.individual.data.model

import android.net.Uri
import com.google.firebase.firestore.DocumentSnapshot
import dev.aman.inquire.utils.InquireState

data class Inquire(
    var id: Int = 0,
    val title:String="",
    val description:String="",
    val inquire_code:String="",
    val language:String="",
    val timestamp: String? = null,
    /*val createdBy: Task<DocumentSnapshot>? = null,*/
    val imageUri: Uri? = null,
    var status: InquireState = InquireState.UnBookmarked,
    var UpVotes:Int=0,

    )