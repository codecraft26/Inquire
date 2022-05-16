package dev.aman.inquire.individual.data

import android.net.Uri
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.FirebaseStorage
import dev.aman.inquire.individual.data.model.Inquire
import dev.aman.inquire.utils.InquireState

class InquireViewModel: ViewModel() {
    var title=""
    var description=""
    var inquire_code=""
    var language=""
    var timestamp=""
    var image_uri: Uri?=null
    var state: InquireState =InquireState.UnBookmarked
    var upvotes=0

    private val db = FirebaseFirestore.getInstance()
    val inquireCollections = db.collection("posts")
    private val auth = Firebase.auth
    val currentUserId = auth.currentUser!!.uid
    val user = UserViewModel().getUserById(currentUserId)
    val currentTime = System.currentTimeMillis().toString()
    val time= currentTime




    fun publishInquire(){
        val inquire= Inquire(title,description,inquire_code,language,image_uri,state,upvotes,)
        inquireCollections.document().set(inquire)
    }
    fun imageUpload(){
        val storage = FirebaseStorage.getInstance()
        val storageRef = storage.reference
        val imageRef = storageRef.child("images/${currentUserId}/${currentTime}")
        imageRef.putFile(image_uri!!)
    }


}