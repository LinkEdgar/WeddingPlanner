package com.example.weddingplanner.ui.gallery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.weddingplanner.R

class WeddingDetailForm : Fragment() {

    private lateinit var viewModel: WeddingDetailFormFragment

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewModel = ViewModelProviders.of(this).get(WeddingDetailFormFragment::class.java)
        val root = inflater.inflate(R.layout.fragment_wedding_detail_form, container, false)
        return root
    }
}