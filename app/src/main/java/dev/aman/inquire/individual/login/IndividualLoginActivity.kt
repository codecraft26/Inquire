package dev.aman.inquire.individual.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.firebase.ui.auth.AuthUI
import com.firebase.ui.auth.FirebaseAuthUIActivityResultContract
import com.firebase.ui.auth.data.model.FirebaseAuthUIAuthenticationResult
import dev.aman.inquire.MainActivity
import dev.aman.inquire.databinding.ActivityLoginIndividualBinding

class IndividualLoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginIndividualBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding= ActivityLoginIndividualBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.signInButton.setOnClickListener{
            // line code for opening a signin intent of google
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
        .setAvailableProviders(listOf(AuthUI.IdpConfig.GoogleBuilder().build())) // choosing only auth for google
        .build()
    private fun onSignInResult(result: FirebaseAuthUIAuthenticationResult) {
        val response = result.idpResponse
        if (result.resultCode == RESULT_OK) {

            val intent= Intent(this@IndividualLoginActivity, MainActivity::class.java)
            startActivity(intent)
            finish()
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
