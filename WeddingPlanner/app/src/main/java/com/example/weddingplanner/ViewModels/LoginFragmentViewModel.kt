package com.example.weddingplanner.ViewModels

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.findNavController
import com.example.weddingplanner.MainActivity
import com.example.weddingplanner.R
import com.example.weddingplanner.Repositories.LoginRepository
import com.example.weddingplanner.Resource
import com.example.weddingplanner.Utils.Util
import com.google.firebase.auth.FirebaseUser

class LoginFragmentViewModel : ViewModel(){

    private var loginRepo= LoginRepository()
    private var isValidEmailAndPassword = MutableLiveData<Boolean>()

    private var email: String = ""
    private var password: String = ""

    fun updateEmailAndPassword(email: String, password: String){
        this.email = email
        this.password = password
    }

    fun switchToCreateAccount(view: View){
        view.findNavController().navigate(R.id.createAccountFragment)
    }

    fun switchToForgotPassword(view: View){
        view.findNavController().navigate(R.id.forgotPasswordFragment)
    }

    fun switchToHome(context: Context){
        val intent = Intent(context, MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        context.startActivity(intent)
    }

    fun isValidEmailAndPassword():MutableLiveData<Boolean>{
        isValidEmailAndPassword = MutableLiveData()
        isValidEmailAndPassword.value = Util.isPasswordValid(password) && Util.isEmailValid(email)
        return isValidEmailAndPassword
    }

    fun signIn(activity: Activity):MutableLiveData<Resource<FirebaseUser?>>{
        return loginRepo.signIn(email, password, activity)
    }

}