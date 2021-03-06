package dev.aman.inquire.individual.data

import androidx.lifecycle.ViewModel
import com.firebase.ui.auth.data.model.User
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class UserViewModel: ViewModel() {
    private val db = FirebaseFirestore.getInstance()
    private val userCollection = db.collection("users")
    private val user: FirebaseUser = Firebase.auth.currentUser!!
    fun addUser(user: User?) {
        user?.let {
            GlobalScope.launch(Dispatchers.IO) {
                userCollection.document().set(it)
            }
        }
    }
    fun getUserById(uId: String) : Task<DocumentSnapshot> {
        return userCollection.document(uId).get()
    }

}