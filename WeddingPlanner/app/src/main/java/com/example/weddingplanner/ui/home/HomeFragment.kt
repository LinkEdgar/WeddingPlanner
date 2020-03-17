package com.example.weddingplanner.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.weddingplanner.R
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private var tv: TextView? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)

        setViews(root)

        getInviteInfo()


        return root
    }

    private fun getInviteInfo(){
        homeViewModel.getNumberOfInvites().observe(viewLifecycleOwner, Observer{ reponse ->
            tv!!.text = reponse
        })
    }

    private fun setViews(root: View){
        tv = root.findViewById(R.id.yes_display)
        val button = root.findViewById<Button>(R.id.send_bt)
        val editText = root.findViewById<EditText>(R.id.input_text)
        button.setOnClickListener{
            sendNumberOfInvites(editText.text.toString().trim())
        }
    }

    private fun sendNumberOfInvites(number: String){
        homeViewModel.sendInvite(number)
    }
}