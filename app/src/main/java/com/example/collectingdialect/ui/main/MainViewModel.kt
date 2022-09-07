package com.example.collectingdialect.ui.main

import android.view.View
import androidx.navigation.findNavController
import com.example.collectingdialect.R
import com.example.collectingdialect.ui.BaseViewModel
import com.example.collectingdialect.ui.SharedViewModel

class MainViewModel: BaseViewModel() {

    var sharedViewModel: SharedViewModel? = null

    fun onClickStartButton(view: View) {
        val isLoggedIn = sharedViewModel?.collectorId?.isNotEmpty() ?: false
        if(isLoggedIn) {
            view.findNavController().navigate(R.id.contentFragment)
        } else {
            view.findNavController().navigate(R.id.loginFragment)
        }
    }
}