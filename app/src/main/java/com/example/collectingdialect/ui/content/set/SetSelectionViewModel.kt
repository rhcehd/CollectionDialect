package com.example.collectingdialect.ui.content.set

import android.view.View
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import com.example.collectingdialect.R
import com.example.collectingdialect.ui.BaseViewModel
import com.example.collectingdialect.ui.SharedViewModel
import com.example.collectingdialect.ui.content.ContentViewModel

class SetSelectionViewModel: BaseViewModel() {
    companion object {
        const val KEY_SELECTED_SET = "set"
        const val SELECTED_SET_1 = 1
        const val SELECTED_SET_2 = 2
        const val SELECTED_SET_3 = 3
    }
    var sharedViewModel: SharedViewModel? = null

    fun onClickSet1Button(view: View) {
        val navController = view.findNavController()
        when(sharedViewModel?.selectedContent) {
            ContentViewModel.SELECTED_CONTENT_ONE_PERSON -> {
                sharedViewModel?.selectedSet = SELECTED_SET_1
                navController.navigate(R.id.repeatFragment)
            }
            ContentViewModel.SELECTED_CONTENT_TWO_PERSON -> {
                sharedViewModel?.selectedSet = SELECTED_SET_1
                navController.navigate(R.id.conversationFragment)
            }
        }
    }

    fun onClickSet2Button(view: View) {
        val navController = view.findNavController()
        when(sharedViewModel?.selectedContent) {
            ContentViewModel.SELECTED_CONTENT_ONE_PERSON -> {
                sharedViewModel?.selectedSet = SELECTED_SET_2
                navController.navigate(R.id.repeatFragment)
            }
            ContentViewModel.SELECTED_CONTENT_TWO_PERSON -> {
                sharedViewModel?.selectedSet = SELECTED_SET_2
                navController.navigate(R.id.conversationFragment)
            }
        }
    }

    fun onClickSet3Button(view: View) {
        val navController = view.findNavController()
        when(sharedViewModel?.selectedContent) {
            ContentViewModel.SELECTED_CONTENT_ONE_PERSON -> {
                sharedViewModel?.selectedSet = SELECTED_SET_3
                navController.navigate(R.id.repeatFragment)
            }
            ContentViewModel.SELECTED_CONTENT_TWO_PERSON -> {
                sharedViewModel?.selectedSet = SELECTED_SET_3
                navController.navigate(R.id.conversationFragment)
            }
        }
    }
}