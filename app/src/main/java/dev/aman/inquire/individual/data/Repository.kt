package dev.aman.inquire.individual.data

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import dev.aman.inquire.individual.model.User

private const val TAG = "Repository"
object Repository {


    val success = MutableLiveData<Boolean>()
    val error = MutableLiveData<String>()
    fun saveUser() {
        var id = ""
        var name = ""
        var photoUrl = ""
        Firebase.auth.currentUser?.let {
            id = it.uid
            name = it.displayName ?: ""
            photoUrl = it.photoUrl?.toString() ?: ""
        }

        val user = User(id,name, photoUrl)
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