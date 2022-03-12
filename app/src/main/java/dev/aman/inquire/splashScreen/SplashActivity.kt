package dev.aman.inquire.splashScreen

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import dev.aman.inquire.ChoosingActivity
import dev.aman.inquire.databinding.ActivitySplashBinding

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {
    private lateinit var  binding:ActivitySplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {


        binding= ActivitySplashBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        Handler().postDelayed({
            val mIntent = Intent(this@SplashActivity, ChoosingActivity::class.java)
            startActivity(mIntent)
            finish()
        }, 2000)

    }
}