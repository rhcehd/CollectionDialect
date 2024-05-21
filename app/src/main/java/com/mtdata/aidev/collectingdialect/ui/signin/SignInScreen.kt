package com.mtdata.aidev.collectingdialect.ui.signin

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.mtdata.aidev.collectingdialect.state.SnackbarVisibleState
import com.mtdata.aidev.collectingdialect.ui.component.CollectingDialectButton
import com.mtdata.aidev.collectingdialect.ui.component.CollectingDialectTextField

@Composable
fun SignInScreen(
    viewModel: SignInViewModel = viewModel(),
    onShowSnackbar: (String) -> Unit,
) {
    val snackbarState by viewModel.snackbarVisibleState.collectAsStateWithLifecycle()
    SignInScreen(
        onClickSignIn = viewModel::onClickSignInButton,
        onClickSingUp = viewModel::onClickSignUpButton,
    )
    if(snackbarState is SnackbarVisibleState.Show) {
        onShowSnackbar((snackbarState as SnackbarVisibleState.Show).msg)
        viewModel.onAfterShowSnackbar()
    }
}

@Composable
private fun SignInScreen(
    onClickSignIn: (String, String) -> Unit,
    onClickSingUp: () -> Unit,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        var idText by remember {
            mutableStateOf("")
        }
        var passwordText by remember{
            mutableStateOf("")
        }
        val paddingModifier = Modifier.padding(vertical = 16.dp)
        CollectingDialectTextField(
            modifier = paddingModifier,
            value = idText,
            onValueChange = {
                idText = it
            },
            label = "아이디"
        )
        CollectingDialectTextField(
            modifier = paddingModifier,
            value = passwordText,
            onValueChange = {
                passwordText = it
            },
            label = "패스워드"
        )
        CollectingDialectButton(
            modifier = paddingModifier,
            onClick = {
                onClickSignIn(idText, passwordText)
            },
            text = "로그인"
        )
        CollectingDialectButton(
            modifier = paddingModifier,
            onClick = {
                onClickSingUp()
            },
            text = "수집자 등록"
        )
    }
}

@Preview
@Composable
fun SignInScreenPreview() {
    MaterialTheme {
        SignInScreen(
            onClickSignIn = {_,_->},
            onClickSingUp = {},
        )
    }
}