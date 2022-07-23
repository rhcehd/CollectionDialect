package com.example.collectingdialect.ui.content

import android.view.View
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import com.example.collectingdialect.R
import com.example.collectingdialect.ui.BaseViewModel

class ContentViewModel: BaseViewModel() {
    companion object {
        const val KEY_SELECTED_CONTENT = "content"
        const val SELECTED_CONTENT_ONE_PERSON = 1
        const val SELECTED_CONTENT_TWO_PERSON = 2
    }
    fun onClickOnePersonButton(view: View) {
        view.findNavController().navigate(R.id.speakerInfoFragment, bundleOf(KEY_SELECTED_CONTENT to SELECTED_CONTENT_ONE_PERSON))
    }

    fun onClickTwoPersonButton(view: View) {
        view.findNavController().navigate(R.id.speakerInfoFragment, bundleOf(KEY_SELECTED_CONTENT to SELECTED_CONTENT_TWO_PERSON))
    }

}