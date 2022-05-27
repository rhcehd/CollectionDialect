package com.example.collectingdialect.ui.collecting.script

import android.view.View
import androidx.navigation.findNavController
import com.example.collectingdialect.ui.collecting.CollectingViewModel

class CollectingScriptViewModel: CollectingViewModel() {

    val adapter = ScriptImageAdapter()

    override fun onClickNextButton(view: View) {
        super.onClickNextButton(view)
    }

    override fun onClickPreviousButton(view: View) {
        super.onClickPreviousButton(view)
        view.findNavController().popBackStack()
    }
}