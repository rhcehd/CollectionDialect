package com.example.collectingdialect.ui.content

import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.findNavController
import com.example.collectingdialect.R
import com.example.collectingdialect.ui.BaseViewModel

class ContentViewModel: BaseViewModel() {
    fun onClickStructuredSpeakButton(view: View) {
        view.findNavController().navigate(R.id.structuredContentFragment)
    }

    fun onClickUnstructuredSpeakButton(view: View) {
        view.findNavController().navigate(R.id.unstructuredContentFragment)
    }

}