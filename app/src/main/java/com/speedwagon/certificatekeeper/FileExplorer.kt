package com.speedwagon.certificatekeeper

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment.getExternalStorageDirectory
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.io.File

class FileExplorer : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_file_explorer)
        // BACK
        findViewById<ImageView>(R.id.goBack).setOnClickListener { finish() }

        // INITIAL ITEM VIEW
        val fileRV = findViewById<RecyclerView>(R.id.fileRV)
        val noItemFound = findViewById<TextView>(R.id.noFileTV)

        // RECRYCLER VIEW HANDLER
        val path : String = intent.getStringExtra("Path").toString()
        val currentPath = File(path)
        val certAndFolderList = currentPath.listFiles()
        //Toast.makeText(this, "the path is $path", Toast.LENGTH_SHORT).show()
        if (certAndFolderList == null)
        {
            noItemFound.visibility = View.VISIBLE
        } else
        {
            noItemFound.visibility = View.INVISIBLE
        }

        fileRV.layoutManager = LinearLayoutManager(this)
        fileRV.adapter = FileAdapter(currentPath, applicationContext)
    }
}