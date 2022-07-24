package com.example.collectingdialect.ui.content.set

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.example.collectingdialect.R
import com.example.collectingdialect.databinding.FragmentSetSelectionBinding
import com.example.collectingdialect.ui.SharedViewModel
import com.example.collectingdialect.ui.content.ContentViewModel

class SetSelectionFragment: Fragment(R.layout.fragment_set_selection) {
    private val viewModel: SetSelectionViewModel by viewModels()
    private val sharedViewModel: SharedViewModel by activityViewModels()
    private var binding: FragmentSetSelectionBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding?.root ?: super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if(binding == null) {
            binding = DataBindingUtil.bind(view)
            binding?.viewModel = viewModel
            viewModel.sharedViewModel = sharedViewModel
        }
    }
}