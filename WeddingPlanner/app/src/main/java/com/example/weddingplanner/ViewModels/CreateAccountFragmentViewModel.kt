package com.example.weddingplanner.ViewModels

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.findNavController
import com.example.weddingplanner.Models.Account
import com.example.weddingplanner.R

class CreateAccountFragmentViewModel : ViewModel(){

    private var isAccountValid = MutableLiveData<Boolean>()

    var account = Account("","","","")

    fun isAccountValid():MutableLiveData<Boolean>{
        isAccountValid = MutableLiveData()
        isAccountValid.value = (
                isEmailValid(account.email)
                && isPasswordValid(account.password)
                &&isNameValid(account.name)
                && doPasswordsMatch(account.password, account.confirmPassword)
        )
        return isAccountValid
    }

    fun switchToSignIn(view: View){
        view.findNavController().navigate(R.id.loginFragment)
    }

    private fun isEmailValid(email: String):Boolean {
        //todo validate the email
        return true
    }

    private fun isNameValid(name: String):Boolean{
        //todo validate name
        return true
    }

    private fun isPasswordValid(password: String):Boolean{
        //todo validate password
        return true
    }

    private fun doPasswordsMatch(password: String, confirmedPass: String):Boolean{
        //todo validate password match
        return true
    }
}