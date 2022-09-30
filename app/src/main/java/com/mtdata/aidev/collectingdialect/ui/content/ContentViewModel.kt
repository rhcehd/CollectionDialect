package com.mtdata.aidev.collectingdialect.ui.content

import android.view.View
import androidx.navigation.findNavController
import com.mtdata.aidev.collectingdialect.R
import com.mtdata.aidev.collectingdialect.ui.BaseViewModel
import com.mtdata.aidev.collectingdialect.ui.SharedViewModel

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