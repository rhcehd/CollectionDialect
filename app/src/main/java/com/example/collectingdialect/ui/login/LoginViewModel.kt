package com.example.collectingdialect.ui.login

import android.content.Context
import android.view.View
import androidx.databinding.Bindable
import androidx.navigation.findNavController
import com.example.collectingdialect.BR
import com.example.collectingdialect.R
import com.example.collectingdialect.remote.ApiManager
import com.example.collectingdialect.ui.BaseViewModel
import com.example.collectingdialect.ui.MainActivity
import com.example.collectingdialect.ui.MainActivity.Companion.showToast

class LoginViewModel: BaseViewModel() {
    companion object {
        const val PREFERENCE_USER = "user"
        const val KEY_ID = "id"
    }

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
        val isValidInput = validateInput()
        if(isValidInput) {
            ApiManager.login(id, password,
                onSuccess = {
                    val preference = view.context.getSharedPreferences(PREFERENCE_USER, Context.MODE_PRIVATE)
                    preference.edit().putString(KEY_ID, id).apply()
                    showToast("로그인 성공")
                    MainActivity.loginCallback?.invoke()
                    val navController = view.findNavController()
                    navController.navigate(R.id.regionSelectionFragment)
                    navController.backQueue.removeLast()
                }, onFailure = { code ->
                    if(code == 401) {
                        showToast("등록되지 않은 사용자 입니다")
                    } else {
                        showToast("로그인 실패. 잠시 후 다시 시도해주세요")
                    }
                })
        } else {
            //do nothing
        }
    }

    fun onClickRegistrationButton(view: View) {
        view.findNavController().navigate(R.id.registrationFragment)
    }
}