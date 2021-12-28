package com.speedwagon.certificatekeeper

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class demo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_demo)

        findViewById<Button>(R.id.toLogIn).setOnClickListener{
            val loginRegisterIntent = Intent(this, LoginRegister::class.java)
            startActivity(loginRegisterIntent)
        }

        findViewById<Button>(R.id.toHome).setOnClickListener{
            val homeIntent = Intent(this, Home::class.java)
            startActivity(homeIntent)
        }

        findViewById<Button>(R.id.toFileExplorer).setOnClickListener{
            val fileExplorerIntent = Intent(this, FileExplorer::class.java)
            startActivity(fileExplorerIntent)
        }

        findViewById<Button>(R.id.toCertView).setOnClickListener{
            val certificateViewIntent = Intent(this, CertivicateView::class.java)
            startActivity(certificateViewIntent)
        }

        findViewById<Button>(R.id.toProfile).setOnClickListener{
            val profileIntent = Intent(this, Profile::class.java)
            startActivity(profileIntent)
        }
    }
}