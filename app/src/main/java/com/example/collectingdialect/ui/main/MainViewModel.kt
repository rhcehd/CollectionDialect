package com.example.collectingdialect.ui.main

import android.content.Context
import android.view.View
import androidx.navigation.findNavController
import com.example.collectingdialect.R
import com.example.collectingdialect.ui.BaseViewModel
import com.example.collectingdialect.ui.login.LoginViewModel

class MainViewModel: BaseViewModel() {

    fun onClickStartButton(view: View) {
        val preference = view.context.getSharedPreferences(LoginViewModel.PREFERENCE_USER, Context.MODE_PRIVATE)
        val isLoggedIn = preference.getString(LoginViewModel.KEY_ID, "")?.isNotEmpty() ?: false
        if(isLoggedIn) {
            //view.findNavController().navigate(R.id.regionSelectionFragment)
            view.findNavController().navigate(R.id.contentFragment)
        } else {
            view.findNavController().navigate(R.id.loginFragment)
        }

    }
}