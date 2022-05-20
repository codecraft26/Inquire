package dev.aman.inquire.splashScreen

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

import dev.aman.inquire.databinding.ActivityOrganisationSplashBinding
import dev.aman.inquire.organisation.OrganisationMainActivity

@SuppressLint("CustomSplashScreen")
class OrganisationSplashActivity : AppCompatActivity() {
    private lateinit var binding: ActivityOrganisationSplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityOrganisationSplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Handler().postDelayed({
            val mIntent = Intent(this, OrganisationMainActivity::class.java)
            startActivity(mIntent)
            finish()
        }, 6000)


    }
}