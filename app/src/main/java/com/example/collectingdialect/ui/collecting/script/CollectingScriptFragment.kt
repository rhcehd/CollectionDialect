package com.example.collectingdialect.ui.collecting.script

import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.collectingdialect.R
import com.example.collectingdialect.databinding.FragmentCollectingScriptBinding

class CollectingScriptFragment: Fragment(R.layout.fragment_collecting_script) {
    private var binding: FragmentCollectingScriptBinding? = null
    private val viewModel: CollectingScriptViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if(binding == null) {
            binding = DataBindingUtil.bind(view)
            binding?.viewModel = viewModel
        }
    }
}