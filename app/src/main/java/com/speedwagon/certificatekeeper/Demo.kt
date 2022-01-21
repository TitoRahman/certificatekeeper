package com.speedwagon.certificatekeeper

import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment.getExternalStorageDirectory
import android.widget.Button
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import java.io.File


class Demo : AppCompatActivity() {
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
            val path : String = getExternalStorageDirectory().toString()
            fileExplorerIntent.putExtra("Path", path)
            if (!checkPermission())
                requestPermission()
            else
                startActivity(fileExplorerIntent)
        }

        findViewById<Button>(R.id.toCertView).setOnClickListener{
            val certificateViewIntent = Intent(this, CertificateView::class.java)
            startActivity(certificateViewIntent)
        }

        findViewById<Button>(R.id.toProfile).setOnClickListener{
            val profileIntent = Intent(this, Profile::class.java)
            startActivity(profileIntent)
        }
    }

    private fun checkPermission() : Boolean
    {
        val permissionIsGranted = ContextCompat.checkSelfPermission(this, android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
        if (permissionIsGranted == PackageManager.PERMISSION_GRANTED) {
            return true
        }
        return false
    }
    private fun requestPermission()
    {
        if (ActivityCompat.shouldShowRequestPermissionRationale(this, android.Manifest.permission.WRITE_EXTERNAL_STORAGE))
        {
            Toast.makeText(this, "Storage Permission is Required, Please allow in Setting", Toast.LENGTH_SHORT).show()
        }
        ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.WRITE_EXTERNAL_STORAGE), 1)
    }
}