package com.example.weddingplanner.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.weddingplanner.InviteGuestsFragmentViewModel
import com.example.weddingplanner.R

class InviteGuestsFragment : Fragment(){

    //todo make this fragment show in one of the hambuger menu screens

    private lateinit var viewModel: InviteGuestsFragmentViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_invite_guests, container, false)
        //TODO find out why the following method has been deprecated and find its alternative
        viewModel = ViewModelProviders.of(this).get(InviteGuestsFragmentViewModel::class.java)

        return view
    }
}