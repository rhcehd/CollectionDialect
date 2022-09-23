package com.example.collectingdialect.ui.collecting.oneperson.repeat

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.example.collectingdialect.R
import com.example.collectingdialect.databinding.FragmentRepeatBinding
import com.example.collectingdialect.ui.SharedViewModel

class RepeatFragment: Fragment(R.layout.fragment_repeat) {
    private var binding: FragmentRepeatBinding? = null
    private val viewModel: RepeatViewModel by viewModels()
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
            viewModel.initializeWithSharedViewModel(sharedViewModel)
        }
    }

    override fun onResume() {
        super.onResume()
        viewModel.onFragmentResume()
    }

    override fun onPause() {
        super.onPause()
        viewModel.onFragmentPause()
    }
}