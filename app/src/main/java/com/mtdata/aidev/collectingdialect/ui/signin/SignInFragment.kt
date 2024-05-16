package com.mtdata.aidev.collectingdialect.ui.signin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.material.MaterialTheme
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.mtdata.aidev.collectingdialect.R
import com.mtdata.aidev.collectingdialect.databinding.FragmentLoginBinding
import com.mtdata.aidev.collectingdialect.ui.SharedViewModel

class SignInFragment: Fragment(R.layout.fragment_login) {
    private val viewModel: SignInViewModel by viewModels()
    private val sharedViewModel: SharedViewModel by activityViewModels()
    private var binding: FragmentLoginBinding? = null

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
            binding?.composeView?.setContent {
                MaterialTheme {
                    SignInScreen()
                }
            }
            binding?.viewModel = viewModel
            binding?.lifecycleOwner = this
            viewModel.sharedViewModel = sharedViewModel
        }
    }
}