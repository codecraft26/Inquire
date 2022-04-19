package dev.aman.inquire

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dev.aman.inquire.databinding.ActivityChoosingBinding
import dev.aman.inquire.individual.ui.login.IndividualLoginActivity
import dev.aman.inquire.splashScreen.OrganisationSplashActivity

class ChoosingActivity : AppCompatActivity() {
    private  lateinit var binding:ActivityChoosingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityChoosingBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.indivdualBtn.setOnClickListener{
            val mIntent = Intent(this, IndividualLoginActivity::class.java)
            startActivity(mIntent)
            finish()
        }
        binding.orgnisationBtn.setOnClickListener{
            val mIntent = Intent(this, OrganisationSplashActivity::class.java)
            startActivity(mIntent)
            finish()
        }

    }
}