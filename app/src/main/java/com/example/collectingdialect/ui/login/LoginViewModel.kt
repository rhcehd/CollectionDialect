package com.example.collectingdialect.ui.login

import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.databinding.Bindable
import androidx.navigation.findNavController
import com.example.collectingdialect.BR
import com.example.collectingdialect.R
import com.example.collectingdialect.remote.ApiManager
import com.example.collectingdialect.remote.request.LoginRequest
import com.example.collectingdialect.remote.response.LoginResponse
import com.example.collectingdialect.ui.BaseViewModel
import com.example.collectingdialect.ui.MainActivity
import com.example.collectingdialect.ui.MainActivity.Companion.showToast
import com.example.collectingdialect.ui.SharedViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginViewModel: BaseViewModel() {
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
        view.context.getSystemService(InputMethodManager::class.java).hideSoftInputFromWindow(view.windowToken, 0)
        val isValidInput = validateInput()
        if(!isValidInput) {
            return
        }
        val loginRequest = LoginRequest(
            id,
            password
        )
        val navController = view.findNavController()
        ApiManager.apiService.login(loginRequest).enqueue(object: Callback<LoginResponse>{
            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                if(response.isSuccessful) {
                    val collectorInfo = response.body()?.collector
                    val collectorId = collectorInfo?.collectorId
                    val collectorBirthYear = collectorInfo?.birthYear
                    val preference = view.context.getSharedPreferences(PREFERENCE_COLLECTOR, Context.MODE_PRIVATE)
                    preference.edit().apply {
                        putString(KEY_ID, collectorId)
                        putInt(KEY_BIRTH_YEAR, collectorBirthYear ?: 9999)
                        apply()
                    }
                    sharedViewModel?.apply {
                        this.collectorId = collectorId
                        this.collectorBirthYear = collectorBirthYear
                    }
                    showToast("로그인 성공")
                    MainActivity.loginCallback?.invoke()
                    navController.navigate(R.id.contentFragment)
                    navController.backQueue.removeLast()
                } else {
                    if(response.code() == 401) {
                        showToast("등록되지 않은 수집자 입니다")
                    } else {
                        showToast("로그인 실패. 잠시 후 다시 시도해주세요")
                    }
                }
            }

            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                showToast("로그인 실패. 잠시 후 다시 시도해주세요")
            }
        })
    }

    fun onClickRegistrationButton(view: View) {
        view.findNavController().navigate(R.id.registrationFragment)
    }
}