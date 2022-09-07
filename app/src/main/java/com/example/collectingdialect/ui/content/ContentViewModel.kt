package com.example.collectingdialect.ui.content

import android.view.View
import androidx.navigation.NavOptions
import androidx.navigation.findNavController
import com.example.collectingdialect.R
import com.example.collectingdialect.ui.BaseViewModel
import com.example.collectingdialect.ui.SharedViewModel

class ContentViewModel: BaseViewModel() {
    companion object {
        const val SELECTED_CONTENT_ONE_PERSON = 1
        const val SELECTED_CONTENT_TWO_PERSON = 2
    }

    var sharedViewModel: SharedViewModel? = null

    fun onClickOnePersonButton(view: View) {
        sharedViewModel?.selectedContent = SELECTED_CONTENT_ONE_PERSON
        view.findNavController().navigate(R.id.speakerInfoOnePersonFragment)
    }

    fun onClickTwoPersonButton(view: View) {
        sharedViewModel?.selectedContent = SELECTED_CONTENT_TWO_PERSON
        view.findNavController().navigate(R.id.speakerInfoTwoPersonFragment)
    }

}