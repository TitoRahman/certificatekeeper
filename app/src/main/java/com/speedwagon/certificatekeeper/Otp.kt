package com.speedwagon.certificatekeeper

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment


class Otp : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.bottomsheet_otp,container,false)
        val btn = v.findViewById<Button>(R.id.btnVerify)
        btn.setOnClickListener{
            val homeIntent = Intent(this@Otp.activity, Home::class.java)
            startActivity(homeIntent)
        }
        return v
    }
}