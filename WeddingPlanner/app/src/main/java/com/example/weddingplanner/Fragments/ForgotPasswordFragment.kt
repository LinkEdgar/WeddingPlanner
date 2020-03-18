package com.example.weddingplanner.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.weddingplanner.R
import com.example.weddingplanner.ViewModels.ForgotPasswordFragmentViewModel
import com.example.weddingplanner.databinding.FragmentForgotPasswordBinding

class ForgotPasswordFragment : Fragment(){


    private var binding:FragmentForgotPasswordBinding? = null
    private val viewModel: ForgotPasswordFragmentViewModel by viewModels()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val root = inflater.inflate(R.layout.fragment_forgot_password,container, false)
        binding = DataBindingUtil.bind(root)
        setViews()
        return root
    }

    private fun setViews(){
        binding!!.resetEmailBt.setOnClickListener{ onResetClicked() }
    }

    private fun onResetClicked(){
        viewModel.onResetClicked(binding!!.emailEt.text.toString().trim())
            .observe(viewLifecycleOwner, Observer { isValid ->
                if(isValid){
                    //TODO progressbar
                    //TODO
                    Toast.makeText(context, "Reset Clicked", Toast.LENGTH_LONG).show()
                }
            })
    }

    private fun sendResetPasswordEmail(){
        //TODO viewModel.sendResetPasswordEmail().observe()
    }
}