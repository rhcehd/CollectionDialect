package com.example.collectingdialect.ui.collecting.thingname

import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.collectingdialect.R
import com.example.collectingdialect.databinding.FragmentCollectingThingNameBinding

class CollectingThingNameFragment: Fragment(R.layout.fragment_collecting_thing_name) {
    private var binding: FragmentCollectingThingNameBinding? = null
    private val viewModel: CollectingThingNameViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if(binding == null) {
            binding = DataBindingUtil.bind(view)
            binding?.viewModel = viewModel
        }
    }
}