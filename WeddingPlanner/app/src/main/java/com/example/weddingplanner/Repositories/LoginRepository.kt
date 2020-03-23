package com.example.weddingplanner.Repositories

import android.app.Activity
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.weddingplanner.Resource
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class LoginRepository{

    private var registeredUser = MutableLiveData<Resource<FirebaseUser?>>()

    private var loginUser = MutableLiveData<Resource<FirebaseUser?>>()

    private var auth = FirebaseAuth.getInstance()

    fun registerUser(email: String, password: String, activity: Activity): MutableLiveData<Resource<FirebaseUser?>>{
        registeredUser = MutableLiveData()
        registeredUser.value = Resource.loading(auth.currentUser)
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(activity){ task ->
                if (task.isSuccessful){
                    registeredUser.postValue(Resource.success(auth.currentUser))
                }else{
                    Log.e(TAG, "${task.exception}")
                    registeredUser.postValue(Resource.error("${task.exception}",auth.currentUser))
                }
            }
        return registeredUser
    }

    fun signIn(email: String, password: String, activity: Activity): MutableLiveData<Resource<FirebaseUser?>>{
        loginUser = MutableLiveData()
        loginUser.value = Resource.loading(auth.currentUser)
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(activity){ task ->
                if(task.isSuccessful){
                    loginUser.postValue(Resource.success(auth.currentUser))
                }else{
                    Log.e(TAG, "${task.exception}")
                    loginUser.postValue(Resource.error("${task.exception}",auth.currentUser))
                }
            }
        return loginUser
    }

    fun getUserLoginStatus(): FirebaseUser?{
        return auth.currentUser
    }

    companion object{
        val TAG = "OnboardingRepository"
    }

}