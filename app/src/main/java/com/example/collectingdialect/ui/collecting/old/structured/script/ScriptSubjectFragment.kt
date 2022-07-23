package com.example.collectingdialect.ui.collecting.old.structured.script

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.collectingdialect.R
import com.example.collectingdialect.databinding.FragmentScriptSubjectBinding
import com.example.collectingdialect.ui.content.region.RegionSelectionViewModel

class ScriptSubjectFragment: Fragment(R.layout.fragment_script_subject) {
    private val viewModel: ScriptSubjectViewModel by viewModels()
    private var binding: FragmentScriptSubjectBinding? = null

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
            val preference = view.context.getSharedPreferences(RegionSelectionViewModel.KEY_REGION, Context.MODE_PRIVATE)
            val regionText = preference.getString(RegionSelectionViewModel.KEY_REGION, "") ?: ""
            viewModel.regionText = regionText
        }
    }
}