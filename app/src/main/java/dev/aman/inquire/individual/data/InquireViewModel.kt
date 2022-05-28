package dev.aman.inquire.individual.data

import android.net.Uri
import androidx.lifecycle.ViewModel
import com.google.android.gms.auth.api.signin.internal.Storage
import com.google.android.gms.tasks.OnFailureListener
import com.google.android.gms.tasks.OnSuccessListener
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import com.google.firebase.storage.UploadTask
import dev.aman.inquire.individual.data.model.Inquire
import dev.aman.inquire.utils.InquireState
import java.util.*
import java.util.UUID.randomUUID

class InquireViewModel: ViewModel() {

    var title=""
    var description=""
    var inquire_code=""
    var language=""
    val fileName = "title" +".jpg"

     var imageUri:String=""
    var state: InquireState =InquireState.UnBookmarked
    var upVotes=0
    var id =(0..5000).random()
    private val db = FirebaseFirestore.getInstance()
    val inquireCollections = db.collection("posts")
    private val auth = Firebase.auth
    val currentUserId = auth.currentUser!!.uid

    val currentTime = System.currentTimeMillis()
    val refStorage = FirebaseStorage.getInstance().reference.child("images/$fileName")




    fun publishInquire(){
        val inquire= Inquire(
            id,
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
    fun uploadImage(uri: Uri){
        val fileName = "title" +".jpg"
        refStorage.putFile(uri).addOnSuccessListener {

            OnSuccessListener<UploadTask.TaskSnapshot>
            {
                refStorage.downloadUrl.addOnSuccessListener {
                    imageUri = it.toString()

                }
                    .addOnFailureListener(OnFailureListener { e ->
                        print(e.message)
                    })

            }





        }



        }


}