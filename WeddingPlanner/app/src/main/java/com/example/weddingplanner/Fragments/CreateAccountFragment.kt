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
import androidx.lifecycle.ViewModelProviders
import com.example.weddingplanner.Models.Account
import com.example.weddingplanner.R
import com.example.weddingplanner.ViewModels.CreateAccountFragmentViewModel
import com.example.weddingplanner.databinding.FragmentCreateAccountBinding

class CreateAccountFragment : Fragment(){

    private val viewModel: CreateAccountFragmentViewModel by viewModels()
    private var binding: FragmentCreateAccountBinding? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val root = inflater.inflate(R.layout.fragment_create_account, container, false)
        binding = DataBindingUtil.bind(root)

        setViews()
        return root
    }

    private fun setViews(){
        binding!!.registerBt.setOnClickListener{ onRegisterClicked() }
        binding!!.signInBt.setOnClickListener{ viewModel.switchToSignIn(view!!) }
    }

    private fun updateAccounttInfo(){
            val name = binding!!.nameEt.text.toString().trim()
            val email = binding!!.emailEt.text.toString().trim()
            val password = binding!!.passwordEt.text.toString().trim()
            val confirmPassword = binding!!.passConfEt.text.toString().trim()
            viewModel.account = (Account(name, email, password, confirmPassword))
    }

    private fun onRegisterClicked(){
        updateAccounttInfo()
        viewModel.isAccountValid().observe(viewLifecycleOwner, Observer { isValid ->
            if(isValid){
                //todo progress bar
                //TODO register with firebase then display toast then swtich to login fragment
                Toast.makeText(context, "Register clicked", Toast.LENGTH_LONG).show()
            }
        })
    }

    private fun registerAccount(){
        //todo viewModel.registerAccount().observe()
    }
}