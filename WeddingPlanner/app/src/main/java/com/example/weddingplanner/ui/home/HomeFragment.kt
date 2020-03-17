package com.example.weddingplanner.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.weddingplanner.R

class HomeFragment : Fragment() {

    private lateinit var viewModel: HomeViewModel
    private var tv: TextView? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)

        setViews(root)

        getInviteInfo()

        if(true) {
            viewModel.switchToLogin(root)

        }


        return root
    }

    private fun getInviteInfo(){
        viewModel.getNumberOfInvites().observe(viewLifecycleOwner, Observer{ reponse ->
            //tv!!.text = reponse
        })
    }

    private fun setViews(root: View){
        val sendButton = root.findViewById<ImageButton>(R.id.send_bt)
        sendButton.setOnClickListener{
            viewModel.switchToInviteFragment(root)
        }
    }

    private fun sendNumberOfInvites(number: String){
        viewModel.sendInvite(number)
    }
}