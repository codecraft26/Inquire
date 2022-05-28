package dev.aman.inquire.individual.data.model


import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.DocumentSnapshot
import dev.aman.inquire.utils.InquireState

data class Inquire(
    var id:Int = 0,
    var title: String = "",
    val description: String = "",
    val inquire_code: String = "",
    val language: String = "",
    val createdBY: String ="",
    val imageUri: String? = null,
    var status: InquireState = InquireState.UnBookmarked,
    var UpVotes: Int = 0,

    )