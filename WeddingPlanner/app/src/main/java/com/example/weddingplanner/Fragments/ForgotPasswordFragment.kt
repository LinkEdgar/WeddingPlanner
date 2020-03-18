package com.example.weddingplanner.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.weddingplanner.R

class ForgotPasswordFragment : Fragment(){


    //TODO create viewmodel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val root = inflater.inflate(R.layout.fragment_forgot_password,container, false)

        return root
    }
}