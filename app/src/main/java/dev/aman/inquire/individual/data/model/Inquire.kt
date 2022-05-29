package dev.aman.inquire.individual.data.model


import androidx.room.PrimaryKey
import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.Exclude
import com.google.firebase.firestore.IgnoreExtraProperties
import dev.aman.inquire.utils.InquireState
import java.util.*

@IgnoreExtraProperties
data class Inquire(
    @Exclude @get: Exclude var id:String = "",
    var title: String = "",
    val description: String = "",
    val inquire_code: String = "",
    val language: String = "",
    val createdBY: String ="",
    val imageUri: String? = null,
    var status: InquireState = InquireState.UnBookmarked,
    var UpVotes: Int = 0,
    var createdAt:Long=0L,
    var userImage:String?=null

    )