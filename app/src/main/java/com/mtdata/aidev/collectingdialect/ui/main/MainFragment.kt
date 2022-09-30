package com.mtdata.aidev.collectingdialect.ui.main

import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.mtdata.aidev.collectingdialect.R
import com.mtdata.aidev.collectingdialect.databinding.FragmentMainBinding
import com.mtdata.aidev.collectingdialect.ui.SharedViewModel

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