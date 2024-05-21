package com.mtdata.aidev.collectingdialect.ui.signup

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mtdata.aidev.collectingdialect.data.PersonalData.academicBackgroundValueOf
import com.mtdata.aidev.collectingdialect.data.PersonalData.collectingOrganizationValueOf
import com.mtdata.aidev.collectingdialect.data.PersonalData.genderValueOf
import com.mtdata.aidev.collectingdialect.data.PersonalData.healthConditionValueOf
import com.mtdata.aidev.collectingdialect.data.PersonalData.residenceCityValueOf
import com.mtdata.aidev.collectingdialect.data.PersonalData.residenceProvinceValueOf
import com.mtdata.aidev.collectingdialect.data.remote.CollectingDialectNetwork
import com.mtdata.aidev.collectingdialect.state.SnackbarVisibleState
import com.mtdata.aidev.collectingdialect.ui.SharedViewModel
import com.mtdata.aidev.collectingdialect.utils.NavigateEvent
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class SignUpViewModel: ViewModel() {
    var sharedViewModel: SharedViewModel? = null

    private val _snackbarVisibleState =
        MutableStateFlow<SnackbarVisibleState>(SnackbarVisibleState.Hide)
    val snackbarVisibleState = _snackbarVisibleState.asStateFlow()

    private val _alertDialogVisibleState =
        MutableStateFlow<AlertDialogVisibleState>(AlertDialogVisibleState.Hide)
    val alertDialogVisibleState = _alertDialogVisibleState.asStateFlow()

    private val _navigateToContent: MutableStateFlow<NavigateEvent?> = MutableStateFlow(null)
    val navigateToContent: StateFlow<NavigateEvent?> = _navigateToContent.asStateFlow()

    private fun validateInput(
        gender: String,
        birthYear: String,
        residenceProvince: String,
        residenceCity: String,
        residencePeriod: String,
        collectingOrganization: String
    ): String {
        if (gender.isEmpty()) {
            return "올바른 성별을 입력해주세요"
        }
        if (birthYear.isEmpty()) {
            return "올바른 출생년도를 입력해주세요"
        }
        if (residenceProvince.isEmpty()) {
            return "올바른 거주 도를 입력해주세요"
        }
        if (residenceCity.isEmpty()) {
            return "올바른 거주 시를 입력해주세요"
        }
        if (residencePeriod.isEmpty()) {
            return "올바른 거주 기간을 입력해주세요"
        }
        if (collectingOrganization.isEmpty()) {
            return "올바른 수집 기관을 입력해주세요"
        }
        return ""
    }

    fun onClickSignUp(
        gender: String,
        birthYear: String,
        residenceProvince: String,
        residenceCity: String,
        residencePeriod: String,
        job: String,
        academicBackground: String,
        healthCondition: String,
        collectingOrganization: String
    ) {
        val errorMsg = validateInput(
            gender,
            birthYear,
            residenceProvince,
            residenceCity,
            residencePeriod,
            collectingOrganization
        )
        if (errorMsg.isNotEmpty()) {
            _snackbarVisibleState.update { SnackbarVisibleState.Show(errorMsg) }
            return
        }
        viewModelScope.launch {
            try {
                val collectorId = CollectingDialectNetwork.signUp(
                    genderValueOf(gender),
                    birthYear.toInt(),
                    residenceProvinceValueOf(residenceProvince),
                    residenceCityValueOf(residenceCity),
                    residencePeriod.toInt(),
                    job,
                    academicBackgroundValueOf(academicBackground),
                    healthConditionValueOf(healthCondition),
                    collectingOrganizationValueOf(collectingOrganization),
                )
                _alertDialogVisibleState.update {
                    AlertDialogVisibleState.Show(
                        msg = "등록된 아이디/패스워드는 다음과 같습니다\n\n아이디 : $collectorId\n패스워드 : $collectorId",
                    )
                }
            } catch (e: Exception) {
                _snackbarVisibleState.update { SnackbarVisibleState.Show("수집자 등록 실패") }
                e.printStackTrace()
            }
        }
    }

    fun onClickCancel() {
        _navigateToContent.update { NavigateEvent(NavigateEvent.ID_NAVIGATE_UP) }
    }

    fun onAfterShowSnackbar() {
        _snackbarVisibleState.update { SnackbarVisibleState.Hide }
    }

    fun onDismissAlertDialog() {
        _alertDialogVisibleState.update { AlertDialogVisibleState.Hide }
        _navigateToContent.update {
            NavigateEvent(NavigateEvent.ID_NAVIGATE_UP)
        }
    }
}

sealed interface AlertDialogVisibleState {
    object Hide: AlertDialogVisibleState
    class Show(
        val msg: String,
    ): AlertDialogVisibleState
}