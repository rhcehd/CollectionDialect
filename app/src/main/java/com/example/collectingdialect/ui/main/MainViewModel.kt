package com.example.collectingdialect.ui.main

import android.view.View
import androidx.lifecycle.ViewModel
import com.example.collectingdialect.ui.BaseViewModel
import com.example.collectingdialect.ui.MainActivity.Companion.showToast

class MainViewModel: BaseViewModel() {

    fun onClickUnit1(view: View) {
        showToast("onClick Unit1")
    }

    fun onClickUnit2(view: View) {
        showToast("onClick Unit2")
    }
}