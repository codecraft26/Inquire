package dev.aman.inquire.individual.ui.home.description

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FirebaseFirestore

class DescriptionViewModel: ViewModel() {
    val success = MutableLiveData<Boolean>()
    val error = MutableLiveData<String>()
    private val db = FirebaseFirestore.getInstance()
    private val postCollection = db.collection("posts")
   fun getInquireById(id:Int): Task<DocumentSnapshot> {
       return postCollection.document(id.toString()).get()


   }

}