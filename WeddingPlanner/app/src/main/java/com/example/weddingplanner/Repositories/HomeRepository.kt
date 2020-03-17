package com.example.weddingplanner.Repositories

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class HomeRepository {


    private val database = Firebase.database
    private var dbReference : DatabaseReference = database.getReference("message")
    private var inviteInformation: MutableLiveData<String> = MutableLiveData()


    fun getInviteInformation(): MutableLiveData<String>{

        dbReference.addValueEventListener(object: ValueEventListener{
            override fun onCancelled(error: DatabaseError) {
                Log.e("HomeRepo", "Error ${error.details}")
            }

            override fun onDataChange(snapshot: DataSnapshot) {
                val value = snapshot.value as String
                inviteInformation.postValue(value)
            }

        })
        return inviteInformation
    }

    fun setInvite(number: String){
        dbReference = database.getReference("message")
        dbReference!!.setValue(number)
    }
}