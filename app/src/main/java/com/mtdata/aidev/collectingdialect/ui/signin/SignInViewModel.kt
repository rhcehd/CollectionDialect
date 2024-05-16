package com.mtdata.aidev.collectingdialect.ui.signin

import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.databinding.Bindable
import androidx.lifecycle.viewModelScope
import androidx.navigation.findNavController
import com.mtdata.aidev.collectingdialect.BR
import com.mtdata.aidev.collectingdialect.R
import com.mtdata.aidev.collectingdialect.data.remote.CollectingDialectNetwork
import com.mtdata.aidev.collectingdialect.data.remote.request.SignInRequest
import com.mtdata.aidev.collectingdialect.ui.BaseViewModel
import com.mtdata.aidev.collectingdialect.ui.MainActivity
import com.mtdata.aidev.collectingdialect.ui.MainActivity.Companion.showToast
import com.mtdata.aidev.collectingdialect.ui.SharedViewModel
import kotlinx.coroutines.launch

class SignInViewModel: BaseViewModel() {
    companion object {
        const val PREFERENCE_COLLECTOR = "collector"
        const val KEY_ID = "collector"
        const val KEY_BIRTH_YEAR = "birth_year"
    }

    var sharedViewModel: SharedViewModel? = null

    var id: String = ""
        @Bindable get
        set(value) {
            if(field != value) {
                field = value
                idError = null
                notifyChange(BR.id)
            }
        }
    var idError: String? = null
        @Bindable get
        set(value) {
            if(field != value) {
                field = value
                notifyChange(BR.idError)
            }
        }

    var password: String = ""
        @Bindable get
        set(value) {
            if(field != value) {
                field = value
                passwordError = null
                notifyChange(BR.password)
            }
        }
    var passwordError: String? = null
        @Bindable get
        set(value) {
            if(field != value) {
                field = value
                notifyChange(BR.passwordError)
            }
        }

    private fun validateInput(): Boolean {
        idError = if(id.isEmpty()) "아이디를 입력해주세요" else null
        passwordError = if(password.isEmpty()) "비밀번호를 입력해주세요" else null
        return idError.isNullOrEmpty() && passwordError.isNullOrEmpty()
    }

    fun onClickLoginButton(view: View) {
        "hello"
        view.context.getSystemService(InputMethodManager::class.java).hideSoftInputFromWindow(view.windowToken, 0)
        val isValidInput = validateInput()
        if(!isValidInput) {
            return
        }
        val loginRequest = SignInRequest(
            id,
            password
        )
        val navController = view.findNavController()
        viewModelScope.launch {
            try {
                val collectorInfo = CollectingDialectNetwork.signIn(id, password)
                val preference = view.context.getSharedPreferences(PREFERENCE_COLLECTOR, Context.MODE_PRIVATE)
                preference.edit().apply {
                    putString(KEY_ID, collectorInfo.collectorId)
                    putInt(KEY_BIRTH_YEAR, collectorInfo.birthYear)
                    apply()
                }
                sharedViewModel?.apply {
                    this.collectorId = collectorInfo.collectorId
                    this.collectorBirthYear = collectorInfo.birthYear
                }
                showToast("로그인 성공")
                MainActivity.loginCallback?.invoke()
                navController.navigate(R.id.contentFragment)
                navController.backQueue.removeLast()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun onClickRegistrationButton(view: View) {
        view.findNavController().navigate(R.id.registrationFragment)
    }
}