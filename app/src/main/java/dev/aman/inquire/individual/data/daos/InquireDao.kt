package dev.aman.inquire.individual.data.daos

import android.net.Uri
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import dev.aman.inquire.individual.model.Inquire
import dev.aman.inquire.utils.InquireState
import dev.aman.inquire.utils.Utils

class InquireDao :ViewModel(){
    var id= (0..50000).shuffled().last()
    var title=""
    var description=""
    var inquire_code=""
    var language=""
    var timestamp=""
    var image_uri:Uri?=null
    var state:InquireState=InquireState.UnBookmarked
    var upvotes=0

    private val db = FirebaseFirestore.getInstance()
    val inquireCollections = db.collection("posts")
    private val auth = Firebase.auth
    val currentUserId = auth.currentUser!!.uid
    val user = UserDao().getUserById(currentUserId)
    val currentTime = System.currentTimeMillis()
    val time=Utils.getTimeAgo(currentTime)




    fun publishInquire(){
       val inquire= Inquire(id,title,description,inquire_code,language,time,user,image_uri,state,upvotes)
        inquireCollections.document().set(inquire)
   }

    }







