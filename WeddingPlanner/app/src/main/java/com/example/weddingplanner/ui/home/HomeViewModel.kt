package com.example.weddingplanner.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.weddingplanner.Repositories.HomeRepository

class HomeViewModel : ViewModel() {

    private var homeRepo = HomeRepository()
    private var numberOfInvites = MutableLiveData<String>()
    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text

    fun getNumberOfInvites(): MutableLiveData<String>{
        return homeRepo.getInviteInformation()
    }

    fun sendInvite(number: String ){
        homeRepo.setInvite(number)
    }


}