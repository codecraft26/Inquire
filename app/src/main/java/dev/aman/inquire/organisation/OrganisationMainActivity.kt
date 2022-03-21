package dev.aman.inquire.organisation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import dev.aman.inquire.R
import dev.aman.inquire.databinding.ActivityOrganisationMainBinding
import dev.aman.inquire.databinding.ActivityOrganisationSplashBinding

class OrganisationMainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityOrganisationMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityOrganisationMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // orgnanisation Activity

    }
}