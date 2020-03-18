package com.example.weddingplanner.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.weddingplanner.R
import com.example.weddingplanner.ViewModels.InviteGuestsFragmentViewModel

class InviteGuestsFragment : Fragment(){

    //todo make this fragment show in one of the hambuger menu screens

    private val viewModel: InviteGuestsFragmentViewModel by viewModels()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_invite_guests, container, false)
        return view
    }
}