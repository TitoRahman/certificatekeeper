package com.speedwagon.certificatekeeper

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Handler().postDelayed({
            val logInIntent = Intent(this@MainActivity, LoginRegister::class.java)
            startActivity(logInIntent)
        }, 1000)
    }
}