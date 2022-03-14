package com.example.collectingdialect.ui.collecting.objectname

import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.collectingdialect.R
import com.example.collectingdialect.databinding.FragmentCollectingThingNameBinding

class CollectingObjectNameFragment: Fragment(R.layout.fragment_collecting_object_name) {
    private var binding: FragmentCollectingThingNameBinding? = null
    private val viewModel: CollectingObjectNameViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if(binding == null) {
            binding = DataBindingUtil.bind(view)
            binding?.viewModel = viewModel
        }
    }
}