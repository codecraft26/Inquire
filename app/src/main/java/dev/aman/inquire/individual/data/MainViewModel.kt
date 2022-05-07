package dev.aman.inquire.individual.data

import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MainViewModel: ViewModel() {
    private val user: FirebaseUser = Firebase.auth.currentUser!!
    

}
