package com.example.weddingplanner.ViewModels

import android.app.Activity
import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.findNavController
import com.example.weddingplanner.Models.Account
import com.example.weddingplanner.R
import com.example.weddingplanner.Repositories.OnboardingRepository
import com.example.weddingplanner.Resource
import com.google.firebase.auth.FirebaseUser

class CreateAccountFragmentViewModel : ViewModel(){

    private var isAccountValid = MutableLiveData<Boolean>()

    private var onboardingRepo = OnboardingRepository()

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
        return onboardingRepo.registerUser(account.email, account.password, activity)
    }

    fun switchToSignIn(view: View){
        view.findNavController().navigate(R.id.loginFragment)
    }

    fun isEmailValid(email: String):Boolean {
        if(email.isEmpty() || !email.contains("@") || !email.contains('.')){
            return false
        }
        return true
    }

    fun isNameValid(name: String):Boolean{
        return name.isNotEmpty() && name.length > 1
    }

    fun isPasswordValid(password: String):Boolean{
        return password.isNotEmpty() && password.length > 6 //firebase min length
    }

    fun doPasswordsMatch(password: String, confirmedPass: String):Boolean{
        return password == confirmedPass
    }
}