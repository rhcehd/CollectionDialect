package com.mtdata.aidev.collectingdialect.ui.signin

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.SnackbarHost
import androidx.compose.material.SnackbarHostState
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.mtdata.aidev.collectingdialect.R
import com.mtdata.aidev.collectingdialect.databinding.FragmentLoginBinding
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch


class SignInFragment: Fragment(R.layout.fragment_login), ContextProvider {
    private val viewModel: SignInViewModel by viewModels { SignInViewModelFactory(this) }
    private var binding: FragmentLoginBinding? = null

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
            MaterialTheme {
                val snackbarHostState = remember {
                    SnackbarHostState()
                }
                val scope = rememberCoroutineScope()
                Box(
                    modifier = Modifier
                        .fillMaxSize(),
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally,
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
                    SnackbarHost(
                        modifier = Modifier.align(Alignment.BottomCenter),
                        hostState = snackbarHostState
                    )
                }
            }
        }
    }
}