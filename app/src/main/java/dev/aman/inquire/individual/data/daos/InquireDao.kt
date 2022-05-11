package dev.aman.inquire.individual.data.daos

import android.net.Uri
import android.nfc.Tag
import android.util.Log
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.FirebaseStorage
import dev.aman.inquire.individual.data.daos.model.Inquire
import dev.aman.inquire.utils.InquireState
import dev.aman.inquire.utils.getUniqueNameForImage

class InquireDao :ViewModel() {

    var title = ""
    var description = ""
    var inquireCode = ""
    var language = ""
    var timestamp = ""
    var image_uri: Uri? = null
    var createdBy: String = ""
    var state: InquireState = InquireState.UnBookmarked
    var upvotes = 0

    private val db = FirebaseFirestore.getInstance()
    val inquireCollections = db.collection("inquires")
    private val auth = Firebase.auth
    val currentTime = System.currentTimeMillis().toString()
    val currentUserId = auth.currentUser!!.uid
    val user = UserDao().getUserById(currentUserId)


    fun publishInquire() {
        val inquire = Inquire(
            title,
            description,
            inquireCode,
            language,
            image_uri,
            currentTime,
            state,
            upvotes
        )
        inquireCollections.document().set(inquire)

    }

    fun UploadImageToFirebase() {
        val storage = FirebaseStorage.getInstance()
        val storageRef = storage.reference
        val imageRef = storageRef.child("images/${getUniqueNameForImage()}")
        image_uri?.let {
            imageRef.putFile(it).addOnSuccessListener {
                Log.d("InquireDao", "Image Uploaded")

            }
        }


    }


}




