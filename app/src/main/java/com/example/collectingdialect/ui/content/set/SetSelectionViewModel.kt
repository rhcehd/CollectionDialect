package com.example.collectingdialect.ui.content.set

import android.view.View
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import com.example.collectingdialect.R
import com.example.collectingdialect.ui.BaseViewModel
import com.example.collectingdialect.ui.content.ContentViewModel

class SetSelectionViewModel: BaseViewModel() {
    companion object {
        const val KEY_SELECTED_SET = "set"
        const val SELECTED_SET_1 = 1
        const val SELECTED_SET_2 = 2
        const val SELECTED_SET_3 = 3
    }
    var selectedContent: Int = 0

    fun onClickSet1Button(view: View) {
        val navController = view.findNavController()
        when(selectedContent) {
            ContentViewModel.SELECTED_CONTENT_ONE_PERSON -> {
                navController.navigate(R.id.repeatFragment, bundleOf(KEY_SELECTED_SET to SELECTED_SET_1))
            }
            ContentViewModel.SELECTED_CONTENT_TWO_PERSON -> {
                navController.navigate(R.id.conversationFragment, bundleOf(KEY_SELECTED_SET to SELECTED_SET_1))
            }
        }
    }

    fun onClickSet2Button(view: View) {
        val navController = view.findNavController()
        when(selectedContent) {
            ContentViewModel.SELECTED_CONTENT_ONE_PERSON -> {
                navController.navigate(R.id.repeatFragment, bundleOf(KEY_SELECTED_SET to SELECTED_SET_2))
            }
            ContentViewModel.SELECTED_CONTENT_TWO_PERSON -> {
                navController.navigate(R.id.conversationFragment, bundleOf(KEY_SELECTED_SET to SELECTED_SET_2))
            }
        }
    }

    fun onClickSet3Button(view: View) {
        val navController = view.findNavController()
        when(selectedContent) {
            ContentViewModel.SELECTED_CONTENT_ONE_PERSON -> {
                navController.navigate(R.id.repeatFragment, bundleOf(KEY_SELECTED_SET to SELECTED_SET_3))
            }
            ContentViewModel.SELECTED_CONTENT_TWO_PERSON -> {
                navController.navigate(R.id.conversationFragment, bundleOf(KEY_SELECTED_SET to SELECTED_SET_3))
            }
        }
    }
}