package com.example.collectingdialect.ui.collecting.interview

import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.collectingdialect.R
import com.example.collectingdialect.databinding.FragmentCollectingInterviewBinding

class CollectingInterviewFragment: Fragment(R.layout.fragment_collecting_interview) {
    private var binding: FragmentCollectingInterviewBinding? = null
    private val viewModel: CollectingInterviewViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if(binding == null) {
            binding = DataBindingUtil.bind(view)
            binding?.viewModel = viewModel
        }
    }
}