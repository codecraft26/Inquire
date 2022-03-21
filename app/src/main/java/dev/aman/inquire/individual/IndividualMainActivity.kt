package dev.aman.inquire.individual

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.firebase.ui.auth.AuthUI
import dev.aman.inquire.ChoosingActivity
import dev.aman.inquire.databinding.ActivityIndividualMainBinding

class IndividualMainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityIndividualMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding= ActivityIndividualMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.logoutBtn.setOnClickListener{
            logout()
            val mIntent = Intent(this, ChoosingActivity::class.java)
            startActivity(mIntent)
            finish()

        }
    }

    private fun logout() {
        AuthUI.getInstance()
            .signOut(this)
    }
}