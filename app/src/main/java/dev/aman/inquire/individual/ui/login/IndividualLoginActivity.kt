package dev.aman.inquire.individual.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import com.facebook.appevents.codeless.internal.ViewHierarchy.setOnClickListener
import com.firebase.ui.auth.AuthUI
import com.firebase.ui.auth.FirebaseAuthUIActivityResultContract
import com.firebase.ui.auth.data.model.FirebaseAuthUIAuthenticationResult
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import dev.aman.inquire.databinding.ActivityLoginIndividualBinding
import dev.aman.inquire.individual.IndividualMainActivity
import dev.aman.inquire.individual.data.InquireViewModel
import dev.aman.inquire.individual.data.Repository
import dev.aman.inquire.individual.ui.profile.ProfileViewModel

class IndividualLoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginIndividualBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding= ActivityLoginIndividualBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.cardViewLoginWithGoogle.setOnClickListener{

            signInLauncher.launch(signInIntent)
        }


    }
    private val signInLauncher = registerForActivityResult(
        FirebaseAuthUIActivityResultContract()
    ) { res ->
        this.onSignInResult(res)
    }
    private val signInIntent = AuthUI.getInstance()
        .createSignInIntentBuilder()
        .setAvailableProviders(listOf(


            AuthUI.IdpConfig.GoogleBuilder().build(),



        )) // choosing only auth for google
        .build()
    private fun onSignInResult(result: FirebaseAuthUIAuthenticationResult) {
        val response = result.idpResponse
        if (result.resultCode == RESULT_OK) {
            if (Firebase.auth.currentUser != null) {
                val intent = Intent(this, IndividualMainActivity::class.java)
                startActivity(intent)
            }
            else {
                Repository.error.observe(this) {
                    Toast.makeText(this, it, Toast.LENGTH_LONG).show()
                }
                Repository.success.observe(this) {

                    val intent = Intent(this, IndividualMainActivity::class.java)
                    startActivity(intent)
                }
                Repository.saveUser()

            }

            val intent= Intent(this@IndividualLoginActivity, IndividualMainActivity::class.java)
            startActivity(intent)

            finish()
            Repository.saveUser()
        } else {

            if (response != null) {

                Toast.makeText(this,
                    "A sign in error occurred! Please try again later!",
                    Toast.LENGTH_SHORT
                ).show()

            }
        }
    }

}
