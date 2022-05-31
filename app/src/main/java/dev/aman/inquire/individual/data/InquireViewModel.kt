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
    val fileName = "title" +".jpg"
    var imageUri:String=""
    var state: InquireState =InquireState.UnBookmarked
    var upVotes=0
    private val db = FirebaseFirestore.getInstance()

    val inquireCollections = db.collection("posts")
    private val auth = Firebase.auth
    val createdBy=auth.currentUser?.displayName.toString()

    val currentTime = System.currentTimeMillis()
    val refStorage = FirebaseStorage.getInstance().reference.child("images/$fileName")

    val createdAt=System.currentTimeMillis()
    val userImage=auth.currentUser?.photoUrl.toString()


    fun publishInquire(){
        val inquire= Inquire(
            id="",
            title,
            description,
            inquire_code,
            language,
            createdBy,
            imageUri,
            state,
            upVotes,
            createdAt,
            userImage
        )
        inquireCollections.add(inquire)
            .addOnSuccessListener {
                println("Inquire added")
            }
            .addOnFailureListener {
                println("Inquire not added")
            }
    }





}






