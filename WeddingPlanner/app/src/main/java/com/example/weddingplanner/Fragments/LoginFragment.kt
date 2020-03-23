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
import com.example.weddingplanner.Resource
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
        binding!!.forgotPassword.setOnClickListener{viewModel.switchToForgotPassword(view!!)}
        binding!!.signInBt.setOnClickListener{ onLoginClicked() }
    }

    private fun onLoginClicked(){
        viewModel.updateEmailAndPassword(
            binding!!.emailEt.text.toString().trim()
            ,binding!!.passwordEt.text.toString().trim())
        viewModel.isValidEmailAndPassword().observe(viewLifecycleOwner, Observer { isValid ->
            if(isValid){
                login()
            }else{
               Toast.makeText(context!!, R.string.unsuccessful_signin, Toast.LENGTH_LONG)
            }
        })
    }

    private fun login(){
        viewModel.signIn(activity!!).observe(viewLifecycleOwner, Observer { response ->
            when(response.status){
                Resource.Status.LOADING -> { binding!!.progress.visibility = View.VISIBLE }
                Resource.Status.SUCCESS -> {
                    binding!!.progress.visibility = View.GONE
                    viewModel.switchToHome(context!!)
                }
                Resource.Status.ERROR -> {
                    binding!!.progress.visibility = View.GONE
                }
            }
        })
    }
}