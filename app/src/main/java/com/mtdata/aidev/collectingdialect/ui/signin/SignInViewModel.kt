package com.mtdata.aidev.collectingdialect.ui.signin

import androidx.lifecycle.viewModelScope
import com.mtdata.aidev.collectingdialect.data.remote.CollectingDialectNetwork
import com.mtdata.aidev.collectingdialect.data.remote.request.SignInRequest
import com.mtdata.aidev.collectingdialect.ui.BaseViewModel
import com.mtdata.aidev.collectingdialect.ui.SharedViewModel
import kotlinx.coroutines.launch

class SignInViewModel: BaseViewModel() {
    companion object {
        const val PREFERENCE_COLLECTOR = "collector"
        const val KEY_ID = "collector"
        const val KEY_BIRTH_YEAR = "birth_year"
    }

    var sharedViewModel: SharedViewModel? = null

    private fun validateInput(id: String, password: String): Boolean {
        val idError = if(id.isEmpty()) "아이디를 입력해주세요" else null
        val passwordError = if(password.isEmpty()) "비밀번호를 입력해주세요" else null
        return idError.isNullOrEmpty() && passwordError.isNullOrEmpty()
    }

    fun onClickSignInButton(id: String, password: String) {
        //view.context.getSystemService(InputMethodManager::class.java).hideSoftInputFromWindow(view.windowToken, 0)
        val isValidInput = validateInput(id, password)
        if(!isValidInput) {
            return
        }
        val loginRequest = SignInRequest(
            id,
            password
        )
        //val navController = view.findNavController()
        viewModelScope.launch {
            try {
                val collectorInfo = CollectingDialectNetwork.signIn(id, password)

                // save preference, navigate content fragment

                /*val preference = view.context.getSharedPreferences(PREFERENCE_COLLECTOR, Context.MODE_PRIVATE)
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
                navController.backQueue.removeLast()*/
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun onClickSignUpButton() {
        //view.findNavController().navigate(R.id.registrationFragment)
    }
}