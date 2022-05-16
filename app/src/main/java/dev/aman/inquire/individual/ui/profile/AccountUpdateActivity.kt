package dev.aman.inquire.individual.ui.profile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dev.aman.inquire.R
import dev.aman.inquire.databinding.ActivityAccountUpdateBinding

class AccountUpdateActivity : AppCompatActivity() {
    private lateinit var binding:ActivityAccountUpdateBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityAccountUpdateBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}