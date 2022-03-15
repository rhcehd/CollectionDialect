package com.example.collectingdialect.ui.content

import android.view.View
import androidx.navigation.findNavController
import com.example.collectingdialect.R
import com.example.collectingdialect.ui.BaseViewModel

class ContentViewModel: BaseViewModel() {
    val adapter = ContentListAdapter {this}

    fun onClickListItem(view: View, position: Int) {
        val navController = view.findNavController()
        when(position) {
            0 -> {
                navController.navigate(R.id.collectingFreeTalkFragment)
            }
            1 -> {
                navController.navigate(R.id.collectingInterviewFragment)
            }
            2 -> {
                navController.navigate(R.id.collectingObjectNameFragment)
            }
        }
    }
}