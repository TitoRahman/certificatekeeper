package com.speedwagon.certificatekeeper

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.FragmentTransaction


class LogIn : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fragment_log_in, container, false)
        val btn = v.findViewById<Button>(R.id.buttonLogin)
        val btn2 = v.findViewById<Button>(R.id.toRegister)

        btn.setOnClickListener{
            val otpFragment = Otp()
            val transaction: FragmentTransaction = parentFragmentManager.beginTransaction()
            transaction.replace(R.id.logResLayout, otpFragment)
            transaction.commit()
        }

        btn2.setOnClickListener {
            val registerFragment = Register()
            val transaction: FragmentTransaction = parentFragmentManager.beginTransaction()
            transaction.replace(R.id.logResLayout, registerFragment)
            transaction.commit()
        }
        return v
    }
}