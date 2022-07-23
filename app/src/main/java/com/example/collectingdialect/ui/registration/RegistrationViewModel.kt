package com.example.collectingdialect.ui.registration

import android.view.View
import androidx.databinding.Bindable
import androidx.navigation.findNavController
import com.example.collectingdialect.BR
import com.example.collectingdialect.remote.ApiManager
import com.example.collectingdialect.ui.BaseViewModel
import com.example.collectingdialect.ui.MainActivity.Companion.showToast

class RegistrationViewModel: BaseViewModel() {
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

    fun onClickRegistrationButton(view: View) {
        val isValidInput = validateInput()
        if(isValidInput) {
            ApiManager.registration(id, password,
                onSuccess = {
                    showToast("회원가입 성공")
                    view.findNavController().popBackStack()
                }, onFailure =  {
                    showToast("회원가입 실패. 잠시 후 다시 시도해주세요")
                })
        } else {
            // do nothing
        }
    }

    fun onClickCancelButton(view: View) {
        view.findNavController().popBackStack()
    }
}