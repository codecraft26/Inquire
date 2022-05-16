package dev.aman.inquire.individual.ui.profile

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.firebase.ui.auth.AuthUI
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import dev.aman.inquire.individual.data.model.User

class ProfileViewModel:ViewModel() {
    val success = MutableLiveData<Boolean>()
    val error = MutableLiveData<String>()
    private val user: FirebaseUser = Firebase.auth.currentUser!!
    private val userCollection = Firebase.firestore.collection("users")
    private val auth = Firebase.auth

    private val db = FirebaseFirestore.getInstance()
    private val userRef = db.collection("users")


    var id = user.uid
    var name = user.displayName ?: ""
    var email = user.email ?: ""
    var photo = user.photoUrl ?: ""
    var bio =""
    var username = ""
    var github_Username = ""


    fun getData() {

        userRef.get()
            .addOnSuccessListener {
                for (document in it) {
                    if (document.id == id) {
                        username = document.data["username"].toString()
                        github_Username = document.data["github_username"].toString()
                        bio = document.data["bio"].toString()
                        name = document.data["name"].toString()
                        email = document.data["email"].toString()
                        photo = document.data["photo"].toString()
                        success.value = true
                    }
                }
            }

    }

    fun logout(){
        FirebaseAuth.getInstance().signOut()

    }
}



