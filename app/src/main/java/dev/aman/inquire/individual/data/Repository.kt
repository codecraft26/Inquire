package dev.aman.inquire.individual.data

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import dev.aman.inquire.individual.data.model.User
private const val TAG = "Repository"
object Repository {

    val success = MutableLiveData<Boolean>()
    val error = MutableLiveData<String>()
  /*  private val user: FirebaseUser = Firebase.auth.currentUser!!
    private val userCollection = Firebase.firestore.collection("users")
    private  val auth= Firebase.auth
    val db = FirebaseFirestore.getInstance()
    var id =user.uid
    var name = user.displayName?:""
    var email = user.email?:""
    var photo = user.photoUrl?:""
    var bio=""
    var username=""
    var github_Username=""*/



    fun saveUser(){
        var id = ""
        var name = ""
        var photoUrl = ""
        var email = ""
        var bio = ""
        var username = ""
        var githubUsername = ""
        Firebase.auth.currentUser?.let {
            id = it.uid
            name = it.displayName ?: ""
            photoUrl = it.photoUrl?.toString() ?: ""
            email = it.email ?: ""
        }

        val user = User(id,username,name,photoUrl,email,bio,githubUsername)
        Firebase
            .firestore
            .collection("users")
            .document(id)
            .set(user)
            .addOnSuccessListener {
                Log.d(TAG, "saveUser successful")
                success.value = true
            }
            .addOnFailureListener {
                Log.d(TAG, "saveUser failed")
                error.value = it.message
            }






    }
}