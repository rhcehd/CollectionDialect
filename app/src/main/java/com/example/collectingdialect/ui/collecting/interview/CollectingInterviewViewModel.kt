package com.example.collectingdialect.ui.collecting.interview

import android.view.View
import androidx.navigation.findNavController
import com.example.collectingdialect.ui.collecting.CollectingViewModel

class CollectingInterviewViewModel: CollectingViewModel() {
    override fun onClickNextButton(view: View) {
        super.onClickNextButton(view)
    }

    override fun onClickPreviousButton(view: View) {
        super.onClickPreviousButton(view)
        view.findNavController().popBackStack()
    }
}