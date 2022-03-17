package com.example.collectingdialect.ui.content

import android.view.View
import androidx.navigation.findNavController
import com.example.collectingdialect.R
import com.example.collectingdialect.ui.BaseViewModel

class ContentViewModel: BaseViewModel() {
    fun onClickScript(view: View) {
        view.findNavController().navigate(R.id.collectingScriptFragment)
    }

    fun onClickInterview(view: View) {
        view.findNavController().navigate(R.id.collectingInterviewFragment)
    }

    override fun onClickNextButton(view: View) {
        super.onClickNextButton(view)
    }

    override fun onClickPreviousButton(view: View) {
        super.onClickPreviousButton(view)
        view.findNavController().popBackStack()
    }
}