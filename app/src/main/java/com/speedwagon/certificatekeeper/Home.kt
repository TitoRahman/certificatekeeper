package com.speedwagon.certificatekeeper

import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.widget.Button
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import java.util.jar.Manifest
import kotlin.contracts.Returns

class Home : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        // Tombol menuju ke File Explorer
        findViewById<CardView>(R.id.toFileExplorer).setOnClickListener{
            val fileExplorerIntent = Intent(this, FileExplorer::class.java)
            val path : String = Environment.getExternalStorageDirectory().path
            fileExplorerIntent.putExtra("path", path)
            if (!checkPermission())
                requestPermission()
            else
                startActivity(fileExplorerIntent)
        }

    }

    // Diluar Fungsi onCreate
    private fun checkPermission() : Boolean
    {
        var permissionIsGranted = ContextCompat.checkSelfPermission(this, android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
        if (permissionIsGranted == PackageManager.PERMISSION_GRANTED)
            return true
        return false
    }
    fun requestPermission()
    {
        if (ActivityCompat.shouldShowRequestPermissionRationale(this, android.Manifest.permission.WRITE_EXTERNAL_STORAGE))
        {
            Toast.makeText(this, "Storage Permission is Required, Please allow in Setting", Toast.LENGTH_SHORT).show()
        }
        ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.WRITE_EXTERNAL_STORAGE), 1)
    }
}