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
        val btnReg = v.findViewById<Button>(R.id.buttonRegister)
        val btnToLog = v.findViewById<Button>(R.id.toLogin)

        btnReg.setOnClickListener{
            val otpFragment = Otp()
            val transaction: FragmentTransaction = parentFragmentManager.beginTransaction()
            transaction.replace(R.id.logResLayout, otpFragment)
            transaction.commit()
        }

        btnToLog.setOnClickListener{
            val loginFragment = LogIn()
            val transaction : FragmentTransaction = parentFragmentManager.beginTransaction()
            transaction.replace(R.id.logResLayout,loginFragment)
            transaction.commit()
        }
        return v
        }
}
