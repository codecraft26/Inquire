package dev.aman.inquire.individual.data

import androidx.lifecycle.ViewModel
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import dev.aman.inquire.individual.data.model.Inquire
import dev.aman.inquire.utils.InquireState

class InquireViewModel: ViewModel() {

    var title=""
    var description=""
    var inquire_code=""
    var language=""

    var image_uri:String=""
    var state: InquireState =InquireState.UnBookmarked
    var upvotes=0

    private val db = FirebaseFirestore.getInstance()
    val inquireCollections = db.collection("posts")
    private val auth = Firebase.auth
    val currentUserId = auth.currentUser!!.uid

    val currentTime = System.currentTimeMillis()





    fun publishInquire(){
        val inquire= Inquire(
            title,
            description,
            inquire_code,
            language,
            currentUserId,
            image_uri,
            state,
            upvotes)
        inquireCollections.document().set(inquire)
    }



}