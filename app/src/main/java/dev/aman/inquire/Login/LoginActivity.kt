package dev.aman.inquire.Login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.firebase.ui.auth.AuthUI
import com.firebase.ui.auth.FirebaseAuthUIActivityResultContract
import com.firebase.ui.auth.data.model.FirebaseAuthUIAuthenticationResult
import dev.aman.inquire.MainActivity
import dev.aman.inquire.R
import dev.aman.inquire.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding= ActivityLoginBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.signInButton.setOnClickListener{
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
        .setAvailableProviders(listOf(AuthUI.IdpConfig.GoogleBuilder().build()))
        .build()
    private fun onSignInResult(result: FirebaseAuthUIAuthenticationResult) {
        val response = result.idpResponse
        if (result.resultCode == RESULT_OK) {

            val intent= Intent(this@LoginActivity, MainActivity::class.java)
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