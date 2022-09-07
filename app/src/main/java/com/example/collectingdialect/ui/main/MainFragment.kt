package com.example.collectingdialect.ui.main

import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.example.collectingdialect.R
import com.example.collectingdialect.databinding.FragmentMainBinding
import com.example.collectingdialect.ui.SharedViewModel

class MainFragment: Fragment(R.layout.fragment_main) {
    private var binding: FragmentMainBinding? = null
    private val viewModel: MainViewModel by viewModels()
    private val sharedViewModel: SharedViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = DataBindingUtil.bind(view)
        binding?.viewModel = viewModel
        viewModel.sharedViewModel = sharedViewModel
    }
}