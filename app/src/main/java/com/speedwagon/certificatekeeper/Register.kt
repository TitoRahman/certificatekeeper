package com.speedwagon.certificatekeeper

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.FragmentTransaction



class Register : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fragment_register, container, false)
        val btn = v.findViewById<Button>(R.id.buttonRegister)
        val btn2 = v.findViewById<Button>(R.id.toLogin)

        btn.setOnClickListener{
            val otpFragment = Otp()
            val transaction: FragmentTransaction = parentFragmentManager.beginTransaction()
            transaction.replace(R.id.logResLayout, otpFragment)
            transaction.commit()
        }

        btn2.setOnClickListener{
            val loginFragment = LogIn()
            val transaction : FragmentTransaction = parentFragmentManager.beginTransaction()
            transaction.replace(R.id.logResLayout,loginFragment)
            transaction.commit()
        }
        return v
        }
}
