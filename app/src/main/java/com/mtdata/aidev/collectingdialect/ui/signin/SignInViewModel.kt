package com.mtdata.aidev.collectingdialect.ui.signin

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.mtdata.aidev.collectingdialect.R
import com.mtdata.aidev.collectingdialect.data.datastore.KEY_COLLECTOR_BIRTH_YEAR
import com.mtdata.aidev.collectingdialect.data.datastore.KEY_COLLECTOR_ID
import com.mtdata.aidev.collectingdialect.data.datastore.dataStore
import com.mtdata.aidev.collectingdialect.data.remote.CollectingDialectNetwork
import com.mtdata.aidev.collectingdialect.state.SnackbarVisibleState
import com.mtdata.aidev.collectingdialect.utils.ContextProvider
import com.mtdata.aidev.collectingdialect.utils.NavigateEvent
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch



@Suppress("UNCHECKED_CAST")
class SignInViewModelFactory(
    private val contextProvider: ContextProvider,
): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(SignInViewModel::class.java)) {
            return SignInViewModel(contextProvider) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}

class SignInViewModel(
    private val contextProvider: ContextProvider,
): ViewModel() {
    private val _snackbarVisibleState: MutableStateFlow<SnackbarVisibleState> = MutableStateFlow(SnackbarVisibleState.Hide)
    val snackbarVisibleState: StateFlow<SnackbarVisibleState> = _snackbarVisibleState.asStateFlow()

    private val _navigateToContent: MutableStateFlow<NavigateEvent?> = MutableStateFlow(null)
    val navigateToContent: StateFlow<NavigateEvent?> = _navigateToContent.asStateFlow()

    fun onClickSignInButton(id: String, password: String) {
        if(id.isEmpty()) {
            _snackbarVisibleState.update { SnackbarVisibleState.Show("아이디를 입력해주세요") }
            return
        }
        if(password.isEmpty()) {
            _snackbarVisibleState.update { SnackbarVisibleState.Show("비밀번호를 입력해주세요") }
            return
        }
        viewModelScope.launch {
            try {
                val collectorInfo = CollectingDialectNetwork.signIn(id, password)
                val context = contextProvider.provideContext()
                context.dataStore.edit { preference ->
                    preference[stringPreferencesKey(KEY_COLLECTOR_ID)] = collectorInfo.collectorId
                    preference[intPreferencesKey(KEY_COLLECTOR_BIRTH_YEAR)] = collectorInfo.birthYear
                }
                _snackbarVisibleState.update { SnackbarVisibleState.Show("로그인 성공") }
                _navigateToContent.update { NavigateEvent(R.id.contentFragment) }
            } catch (e: Exception) {
                _snackbarVisibleState.update { SnackbarVisibleState.Show("로그인 실패") }
                e.printStackTrace()
            }
        }
    }

    fun onClickSignUpButton() {
        _navigateToContent.update { NavigateEvent(R.id.registrationFragment) }
    }

    fun onAfterShowSnackbar() {
        _snackbarVisibleState.update { SnackbarVisibleState.Hide }
    }
}
