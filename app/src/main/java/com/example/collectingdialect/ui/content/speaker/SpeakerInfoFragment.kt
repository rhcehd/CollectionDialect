package com.example.collectingdialect.ui.content.speaker

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.clearFragmentResultListener
import androidx.fragment.app.setFragmentResultListener
import androidx.fragment.app.viewModels
import com.example.collectingdialect.R
import com.example.collectingdialect.databinding.FragmentSpeakerInfoBinding
import com.example.collectingdialect.ui.content.ContentViewModel
import com.example.collectingdialect.ui.content.region.RegionSelectionViewModel

class SpeakerInfoFragment: Fragment(R.layout.fragment_speaker_info) {
    val viewModel: SpeakerInfoViewModel by viewModels()
    var binding: FragmentSpeakerInfoBinding? = null

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
            viewModel.selectedContent = arguments?.getInt(ContentViewModel.KEY_SELECTED_CONTENT) ?: 0
            setFragmentResultListener(RegionSelectionViewModel.KEY_REGION, viewModel.regionSelectResultListener)
        }
    }

    override fun onResume() {
        super.onResume()
        activity?.window?.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE)
    }

    override fun onPause() {
        super.onPause()
        activity?.window?.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_NOTHING)
    }
}