package com.mtdata.aidev.collectingdialect.ui.content

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.mtdata.aidev.collectingdialect.R
import com.mtdata.aidev.collectingdialect.databinding.FragmentContentBinding
import com.mtdata.aidev.collectingdialect.ui.SharedViewModel

class ContentFragment: Fragment(R.layout.fragment_content) {
    private var binding: FragmentContentBinding? = null
    private val viewModel: ContentViewModel by viewModels()
    private val sharedViewModel: SharedViewModel by activityViewModels()

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