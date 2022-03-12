package dev.aman.inquire.Login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dev.aman.inquire.R
import dev.aman.inquire.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding= ActivityLoginBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)




    }
}