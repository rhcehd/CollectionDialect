package com.mtdata.aidev.collectingdialect.ui.signup

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.lifecycle.viewmodel.compose.viewModel
import com.mtdata.aidev.collectingdialect.ui.component.CollectingDialectButton
import com.mtdata.aidev.collectingdialect.ui.component.CollectingDialectDropdownTextField
import com.mtdata.aidev.collectingdialect.ui.component.CollectingDialectTextField

@Composable
fun SignUpScreen(
    viewModel: SignUpViewModel = viewModel(),
    onShowSnackbar: (String) -> Unit,
) {
    SignUpScreen(a = 1)
}

@Composable
private fun SignUpScreen(
    a: Int
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
                    items = listOf("a", "b"),
                )
                CollectingDialectDropdownTextField(
                    value = residenceProvince,
                    onValueChange = { residenceProvince = it },
                    label = "거주 도",
                )
                CollectingDialectTextField(
                    value = residencePeriod,
                    onValueChange = { residencePeriod = it },
                    label = "거주 기간"
                )
                CollectingDialectDropdownTextField(
                    value = academicBackground,
                    onValueChange = { academicBackground = it },
                    label = "학력"
                )
            }
            Column(
                modifier = Modifier.weight(1f)
            ) {
                CollectingDialectTextField(
                    value = birthYear,
                    onValueChange = { birthYear = it },
                    label = "출생년도"
                )
                CollectingDialectDropdownTextField(
                    value = residenceCity,
                    onValueChange = { residenceCity = it },
                    label = "거주 시"
                )
                CollectingDialectTextField(
                    value = job,
                    onValueChange = { job = it },
                    label = "직업"
                )
                CollectingDialectDropdownTextField(
                    value = healthCondition,
                    onValueChange = { healthCondition = it },
                    label = "건강상태"
                )
            }
        }
        CollectingDialectDropdownTextField(
            value = collectingOrganization,
            onValueChange = { collectingOrganization = it },
            label = "수집기관"
        )

        CollectingDialectButton(
            modifier = Modifier.padding(top = 16.dp),
            text = "등록",
            onClick = {

            }
        )
        CollectingDialectButton(
            modifier = Modifier.padding(top = 16.dp),
            text = "취소",
            onClick = {

            }
        )
    }
}

@Composable
@Preview
private fun SignUpScreenPreview() {
    MaterialTheme {
        SignUpScreen(a = 1)
    }
}

