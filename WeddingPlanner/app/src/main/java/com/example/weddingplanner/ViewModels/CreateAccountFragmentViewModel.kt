package com.example.weddingplanner.ViewModels

import android.app.Activity
import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.findNavController
import com.example.weddingplanner.Models.Account
import com.example.weddingplanner.R
import com.example.weddingplanner.Repositories.LoginRepository
import com.example.weddingplanner.Resource
import com.example.weddingplanner.Utils.Util
import com.google.firebase.auth.FirebaseUser

class CreateAccountFragmentViewModel : ViewModel(){

    private var isAccountValid = MutableLiveData<Boolean>()

    private var loginRepo = LoginRepository()

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

    fun registerAccount(activity: Activity):MutableLiveData<Resource<FirebaseUser?>>{
        return loginRepo.registerUser(account.email, account.password, activity)
    }

    fun switchToSignIn(view: View){
        view.findNavController().navigate(R.id.loginFragment)
    }

    fun isEmailValid(email: String):Boolean {
        return Util.isEmailValid(email)
    }

    fun isNameValid(name: String):Boolean{
        return Util.isNameValid(name)
    }

    fun isPasswordValid(password: String):Boolean{
        return Util.isPasswordValid(password)
    }

    fun doPasswordsMatch(password: String, confirmedPass: String):Boolean{
        return Util.doPasswordsMatch(password, confirmedPass)
    }
}