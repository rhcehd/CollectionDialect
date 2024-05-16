package com.mtdata.aidev.collectingdialect.ui.signin

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun SignInScreen(
    viewModel: SignInViewModel = viewModel()
) {
    val uiState = 0
    SignInScreen(
        uiState = uiState,
        onClickSignIn = viewModel::onClickSignInButton,
        onClickSingUp = viewModel::onClickSignUpButton
    )
}

@Composable
private fun SignInScreen(
    uiState: Int,
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

@Composable
fun CollectingDialectTextField(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    error: String = "",
) {
    OutlinedTextField(
        modifier = modifier,
        value = value,
        onValueChange = onValueChange,
        singleLine = true,
        label = {
            Text(text = label)
        },
        isError = error.isNotEmpty(),

    )
}

@Composable
fun CollectingDialectButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    text: String = "",
) {
    Button(
        modifier = modifier
            .fillMaxWidth(0.8f)
            .height(60.dp),
        onClick = onClick
    ) {
        Text(text = text)
    }
}

@Preview
@Composable
fun SignInScreenPreview() {
    MaterialTheme {
        SignInScreen(
            uiState = 0,
            onClickSignIn = {_,_->},
            onClickSingUp = {},
        )
    }
}