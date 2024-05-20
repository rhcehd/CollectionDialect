package com.mtdata.aidev.collectingdialect.ui.signup

import android.os.Bundle
import android.view.View
import androidx.compose.material.SnackbarHostState
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.mtdata.aidev.collectingdialect.R
import com.mtdata.aidev.collectingdialect.databinding.FragmentSignUpBinding
import com.mtdata.aidev.collectingdialect.ui.theme.MaterialSnackbarTheme
import kotlinx.coroutines.launch

class SignUpFragment: Fragment(R.layout.fragment_sign_up) {
    private val viewModel: SignUpViewModel by viewModels()
    private var binding: FragmentSignUpBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = DataBindingUtil.bind(view)
        binding?.composeView?.setContent {
            val snackbarHostState = remember {
                SnackbarHostState()
            }
            val scope = rememberCoroutineScope()
            MaterialSnackbarTheme(
                snackbarHostState = snackbarHostState
            ) {
                SignUpScreen(
                    onShowSnackbar = { msg ->
                        scope.launch {
                            snackbarHostState.showSnackbar(msg)
                        }
                    }
                )
            }
        }
    }

    /*override fun onResume() {
        super.onResume()
        activity?.window?.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE)
    }

    override fun onPause() {
        super.onPause()
        activity?.window?.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_NOTHING)
    }*/
}