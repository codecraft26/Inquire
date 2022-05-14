package dev.aman.inquire.splashScreen

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import dev.aman.inquire.ChoosingActivity
import dev.aman.inquire.databinding.ActivitySplashBinding
import dev.aman.inquire.individual.IndividualMainActivity

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {
    private lateinit var  binding:ActivitySplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {


        binding= ActivitySplashBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        if (Firebase.auth.currentUser != null) {
            Handler().postDelayed({
                val mIntent = Intent(this@SplashActivity, IndividualMainActivity::class.java)
                startActivity(mIntent)
                finish()
            }, 2000)
        }
        else{
            val mIntent = Intent(this@SplashActivity, ChoosingActivity::class.java)
            startActivity(mIntent)
            finish()
        }




    }
}