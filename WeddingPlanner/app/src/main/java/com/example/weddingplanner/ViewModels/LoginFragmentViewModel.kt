package com.example.weddingplanner.ViewModels

import android.view.View
import androidx.lifecycle.ViewModel
import androidx.navigation.findNavController
import com.example.weddingplanner.R

class LoginFragmentViewModel : ViewModel(){

    fun switchToCreateAccount(view: View){
        view.findNavController().navigate(R.id.createAccountFragment)
    }
}