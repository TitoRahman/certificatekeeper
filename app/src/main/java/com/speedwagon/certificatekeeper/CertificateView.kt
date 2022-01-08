package com.speedwagon.certificatekeeper

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

class CertificateView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_certivicate_view)

        // Back Button
        findViewById<ImageView>(R.id.goBack).setOnClickListener { finish() }

        // Tool List
        val toolList = mutableListOf(
            Option(title = "Contrast"),
            Option(title = "Crop"),
            Option(title = "W/B"),
            Option(title = "Rename"),
            Option(title = "Protect")
        )

        val toolAdapter = optionAdapter(toolList)
        findViewById<RecyclerView>(R.id.rvToolList).adapter = toolAdapter
    }
}