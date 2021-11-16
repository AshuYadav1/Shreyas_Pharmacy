package com.shreyas.shreyaspharmacy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper

class splashscreen : AppCompatActivity() {
    private val SPLASH_TIME_OUT:Long = 10000// 1 sec = 3000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splashscreen)

        Handler(Looper.getMainLooper()).postDelayed({

            startActivity(Intent(this,MainActivity::class.java))
            finish()
        },SPLASH_TIME_OUT)

    }
}