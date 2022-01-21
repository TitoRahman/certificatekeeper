package com.speedwagon.certificatekeeper

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

class CertificateView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_certivicate_view)

        // Button Event Listener
        findViewById<ImageView>(R.id.goBack).setOnClickListener { finish() }
        findViewById<ImageView>(R.id.Edit).setOnClickListener{finish()}
        // Tool List
        val toolList = mutableListOf(
            Option(toolTitle = "Contrast", toolIcon = R.drawable.ic_contrast),
            Option(toolTitle = "Crop", toolIcon =  R.drawable.ic_crop),
            Option(toolTitle = "Rename", toolIcon =  R.drawable.ic_rename),
            Option(toolTitle = "Lock", toolIcon =  R.drawable.ic_lock)
        )
        val tool = findViewById<RecyclerView>(R.id.rvToolList)
        val toolAdapter = OptionAdapter(toolList)
        tool.adapter = toolAdapter

    }
}