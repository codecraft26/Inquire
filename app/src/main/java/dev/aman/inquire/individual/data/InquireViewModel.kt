package dev.aman.inquire.individual.data

import android.net.Uri
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import dev.aman.inquire.individual.data.model.Inquire
import dev.aman.inquire.utils.InquireState

class InquireViewModel: ViewModel() {

    var title=""
    var description=""
    var inquire_code=""
    var language=""

     private var imageUri:String=""
    var state: InquireState =InquireState.UnBookmarked
    var upVotes=0

    private val db = FirebaseFirestore.getInstance()
    val inquireCollections = db.collection("posts")
    private val auth = Firebase.auth
    val currentUserId = auth.currentUser!!.uid

    val currentTime = System.currentTimeMillis()
    val storageReference:StorageReference=FirebaseStorage.getInstance().reference




    fun publishInquire(){
        val inquire= Inquire(
            title,
            description,
            inquire_code,
            language,
            currentUserId,
            imageUri,
            state,
            upVotes)
        inquireCollections.document().set(inquire)
    }



}