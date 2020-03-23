package com.example.weddingplanner.ViewModels

import android.content.Context
import android.content.Intent
import androidx.lifecycle.ViewModel
import com.example.weddingplanner.Activities.LoginActvitiy
import com.example.weddingplanner.Repositories.LoginRepository
import com.google.firebase.auth.FirebaseUser

class MainActivityViewModel : ViewModel(){


    private var loginRepo = LoginRepository()

    fun checkLoginStatus(): FirebaseUser?{
        return  loginRepo.getUserLoginStatus()
    }

    fun switchToLogin(context: Context){
        val intent = Intent(context, LoginActvitiy::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        context.startActivity(intent)
    }
}