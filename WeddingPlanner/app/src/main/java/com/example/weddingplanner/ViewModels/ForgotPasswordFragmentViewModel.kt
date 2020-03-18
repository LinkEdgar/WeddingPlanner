package com.example.weddingplanner.ViewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ForgotPasswordFragmentViewModel : ViewModel(){

    private var isValidEmail = MutableLiveData<Boolean>()


    fun onResetClicked(email: String): MutableLiveData<Boolean>{
        isValidEmail = MutableLiveData()
        isValidEmail.value = isEmailValid(email)
        return isValidEmail
    }

    fun isEmailValid(email: String):Boolean{
        return true
    }
}