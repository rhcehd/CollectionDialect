package com.mtdata.aidev.collectingdialect.ui.signin

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.compose.material.SnackbarHostState
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.mtdata.aidev.collectingdialect.R
import com.mtdata.aidev.collectingdialect.databinding.FragmentSignInBinding
import com.mtdata.aidev.collectingdialect.ui.theme.MaterialSnackbarTheme
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch


class SignInFragment: Fragment(R.layout.fragment_sign_in), ContextProvider {
    private val viewModel: SignInViewModel by viewModels { SignInViewModelFactory(this) }
    private var binding: FragmentSignInBinding? = null

    override fun provideContext(): Context = requireContext()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = DataBindingUtil.bind(view)
        lifecycleScope.launch {
            viewModel.navigateToContent.collectLatest { event ->
                event?.getContentIfNotHandled()?.let { navigateResId ->
                    findNavController().navigate(navigateResId)
                }
            }
        }
        binding?.composeView?.setContent {
            val snackbarHostState = remember {
                SnackbarHostState()
            }
            val scope = rememberCoroutineScope()
            MaterialSnackbarTheme(
                snackbarHostState = snackbarHostState
            ) {
                SignInScreen(
                    onShowSnackbar = { msg ->
                        scope.launch {
                            snackbarHostState.showSnackbar(
                                message = msg
                            )
                        }
                    }
                )
            }
        }
    }
}