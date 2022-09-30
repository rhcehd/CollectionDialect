package com.mtdata.aidev.collectingdialect.ui.collecting.twoperson.conversation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.mtdata.aidev.collectingdialect.R
import com.mtdata.aidev.collectingdialect.databinding.FragmentConversationBinding
import com.mtdata.aidev.collectingdialect.ui.SharedViewModel

class ConversationFragment: Fragment(R.layout.fragment_conversation) {
    private val viewModel: ConversationViewModel by viewModels()
    private val sharedViewModel: SharedViewModel by activityViewModels()
    private var binding: FragmentConversationBinding? = null

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