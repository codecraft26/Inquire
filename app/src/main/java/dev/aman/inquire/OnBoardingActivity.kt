package dev.aman.inquire

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dev.aman.inquire.databinding.ActivityOnBoardingBinding
import dev.aman.inquire.databinding.FragmentAccountBinding

class OnBoardingActivity : AppCompatActivity() {
    private lateinit var binding: ActivityOnBoardingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding= ActivityOnBoardingBinding.inflate(layoutInflater)
        setContentView(binding.root)


        getAllItems()
    }

    private fun getAllItems() {
        

    }

}