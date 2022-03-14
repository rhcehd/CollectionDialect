package com.example.collectingdialect.ui.collecting.freetalk

import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.collectingdialect.R
import com.example.collectingdialect.databinding.FragmentCollectingFreeTalkBinding

class CollectingFreeTalkFragment: Fragment(R.layout.fragment_collecting_free_talk) {
    private var binding: FragmentCollectingFreeTalkBinding? = null
    private val viewModel: CollectingFreeTalkViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if(binding == null) {
            binding = DataBindingUtil.bind(view)
            binding?.viewModel = viewModel
        }
    }
}