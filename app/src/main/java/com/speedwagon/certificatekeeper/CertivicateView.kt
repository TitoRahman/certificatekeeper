package com.speedwagon.certificatekeeper

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.widget.ImageView
import android.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CertivicateView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_certivicate_view)

        // Back Button
        findViewById<ImageView>(R.id.goBack).setOnClickListener { finish() }

        // Tool List
        var toolList = mutableListOf<Option>(
            Option(title = "CONTRAST"),
            Option(title = "CROP"),
            Option(title = "WHITE BALANCE"),
            Option(title = "RENAME")
        )

        var toolAdapter = optionAdapter(toolList)
        findViewById<RecyclerView>(R.id.rvToolList).adapter = toolAdapter
        findViewById<RecyclerView>(R.id.rvToolList).layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
    }
}