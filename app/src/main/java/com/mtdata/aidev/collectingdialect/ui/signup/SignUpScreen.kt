package com.mtdata.aidev.collectingdialect.ui.signup

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.mtdata.aidev.collectingdialect.data.PersonalData
import com.mtdata.aidev.collectingdialect.state.SnackbarVisibleState
import com.mtdata.aidev.collectingdialect.ui.component.CollectingDialectButton
import com.mtdata.aidev.collectingdialect.ui.component.CollectingDialectDropdownTextField
import com.mtdata.aidev.collectingdialect.ui.component.CollectingDialectTextField

@Composable
fun SignUpScreen(
    viewModel: SignUpViewModel = viewModel(),
    onShowSnackbar: (String) -> Unit,
) {
    val snackbarVisibleState by viewModel.snackbarVisibleState.collectAsStateWithLifecycle()
    val alertDialogVisibleState by viewModel.alertDialogVisibleState.collectAsStateWithLifecycle()
    SignUpScreen(
        onClickSignUp = viewModel::onClickSignUp,
        onClickCancel = viewModel::onClickCancel
    )
    when(val state = snackbarVisibleState) {
        is SnackbarVisibleState.Show -> {
            onShowSnackbar(state.msg)
            viewModel.onAfterShowSnackbar()
        }
        is SnackbarVisibleState.Hide -> {}
    }
    when(val state = alertDialogVisibleState) {
        is AlertDialogVisibleState.Show -> {
            AlertDialog(
                text = {
                    Text(text = state.msg)
                },
                onDismissRequest = {
                    viewModel.onDismissAlertDialog()
                },
                confirmButton = {
                    Button(
                        onClick = {
                            viewModel.onDismissAlertDialog()
                        }
                    ) {
                        Text(text = "확인")
                    }
                }
            )
        }
        is AlertDialogVisibleState.Hide -> {}
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
private fun SignUpScreen(
    onClickSignUp: (String, String, String, String, String, String, String, String, String) -> Unit,
    onClickCancel: () -> Unit,
) {
    var gender by remember{ mutableStateOf("") }
    var birthYear by remember { mutableStateOf("") }
    var residenceProvince by remember { mutableStateOf("") }
    var residenceCity by remember { mutableStateOf("") }
    var residencePeriod by remember { mutableStateOf("") }
    var job by remember { mutableStateOf("") }
    var academicBackground by remember { mutableStateOf("") }
    var healthCondition by remember { mutableStateOf("") }
    var collectingOrganization by remember { mutableStateOf("") }

    val keyboardController = LocalSoftwareKeyboardController.current

    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row {
            Column(
                modifier = Modifier.weight(1f)
            ) {
                CollectingDialectDropdownTextField(
                    value = gender,
                    onValueChange = { gender = it },
                    label = "성별",
                    items = PersonalData.genderList.toList(),
                )
                CollectingDialectDropdownTextField(
                    value = residenceProvince,
                    onValueChange = { residenceProvince = it },
                    label = "거주 도",
                    items = PersonalData.residenceProvinceList.toList()
                )
                CollectingDialectTextField(
                    value = residencePeriod,
                    onValueChange = { residencePeriod = it },
                    label = "거주 기간",
                    keyboardType = KeyboardType.Number
                )
                CollectingDialectDropdownTextField(
                    value = academicBackground,
                    onValueChange = { academicBackground = it },
                    label = "학력",
                    items = PersonalData.academicBackgroundList.toList()
                )
            }
            Column(
                modifier = Modifier.weight(1f)
            ) {
                CollectingDialectTextField(
                    value = birthYear,
                    onValueChange = { birthYear = it },
                    label = "출생년도",
                    keyboardType = KeyboardType.Number
                )
                CollectingDialectDropdownTextField(
                    value = residenceCity,
                    onValueChange = { residenceCity = it },
                    label = "거주 시",
                    items = PersonalData.getResidenceCityByProvince(province = residenceProvince)
                )
                CollectingDialectTextField(
                    value = job,
                    onValueChange = { job = it },
                    label = "직업"
                )
                CollectingDialectDropdownTextField(
                    value = healthCondition,
                    onValueChange = { healthCondition = it },
                    label = "건강상태",
                    items = PersonalData.healthConditionList.toList()
                )
            }
        }
        CollectingDialectDropdownTextField(
            value = collectingOrganization,
            onValueChange = { collectingOrganization = it },
            label = "수집기관",
            items = PersonalData.collectingOrganizationList.toList()
        )

        CollectingDialectButton(
            modifier = Modifier.padding(top = 16.dp),
            text = "등록",
            onClick = {
                keyboardController?.hide()
                onClickSignUp(
                    gender,
                    birthYear,
                    residenceProvince,
                    residenceCity,
                    residencePeriod,
                    job,
                    academicBackground,
                    healthCondition,
                    collectingOrganization
                )
            }
        )
        CollectingDialectButton(
            modifier = Modifier.padding(top = 16.dp),
            text = "취소",
            onClick = {
                keyboardController?.hide()
                onClickCancel()
            }
        )
    }
}

@Composable
@Preview
private fun SignUpScreenPreview() {
    MaterialTheme {
        SignUpScreen(
            onClickSignUp = {_,_,_,_,_,_,_,_,_->},
            onClickCancel = {}
        )
    }
}

