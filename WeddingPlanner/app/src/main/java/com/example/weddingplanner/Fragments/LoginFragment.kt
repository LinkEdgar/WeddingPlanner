package com.example.weddingplanner.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.weddingplanner.R
import com.example.weddingplanner.ViewModels.LoginFragmentViewModel
import com.example.weddingplanner.databinding.FragmentLoginBinding

class LoginFragment : Fragment(){


    private var binding: FragmentLoginBinding? = null
    private val viewModel: LoginFragmentViewModel by viewModels()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val root = inflater.inflate(R.layout.fragment_login, container, false)
        binding = DataBindingUtil.bind(root)
        setViews()
        return root
    }

    private fun setViews(){
        binding!!.createAccount.setOnClickListener{viewModel.switchToCreateAccount(view!!)}
        binding!!.forgotPasswrod.setOnClickListener{viewModel.switchToForgotPassword(view!!)}
    }
}