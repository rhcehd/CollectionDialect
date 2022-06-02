package com.example.collectingdialect.ui.main

import android.view.View
import androidx.navigation.findNavController
import com.example.collectingdialect.R
import com.example.collectingdialect.ui.BaseViewModel

class MainViewModel: BaseViewModel() {

    fun onClickStartButton(view: View) {
        view.findNavController().navigate(R.id.regionSelectionFragment)
    }
}