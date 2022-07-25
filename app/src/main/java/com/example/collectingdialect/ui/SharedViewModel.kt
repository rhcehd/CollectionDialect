package com.example.collectingdialect.ui

import android.graphics.Color
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.appcompat.widget.AppCompatButton
import androidx.core.view.updateLayoutParams
import androidx.navigation.NavOptions
import androidx.navigation.findNavController
import com.example.collectingdialect.R
import com.example.collectingdialect.data.RecordManager
import com.example.collectingdialect.data.SpeakerInfo
import com.example.collectingdialect.ui.MainActivity.Companion.showToast
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class SharedViewModel: BaseViewModel() {
    companion object {
        const val COLLECTING_TYPE_NON_COLLECTING = 0
        const val COLLECTING_TYPE_ONE_PERSON = 1
        const val COLLECTING_TYPE_TWO_PERSON = 2
    }
    var collectingType: Int = COLLECTING_TYPE_NON_COLLECTING
        set(value) {
            if(field != value) {
                if(value == COLLECTING_TYPE_NON_COLLECTING
                    || value == COLLECTING_TYPE_ONE_PERSON
                    || value == COLLECTING_TYPE_TWO_PERSON) {
                    field = value
                    RecordManager.updateRecordTime()
                } else {
                    return
                }
            }
        }
    var currentSpeakerInfo: SpeakerInfo? = null
        set(value) {
            if(field?.equals(value) != true) {
                field = value
                RecordManager.clearRecordDirectory()
            }
        }
    var selectedContent: Int? = null
        set(value) {
            if(field != value) {
                field = value
                RecordManager.clearRecordDirectory()
            }
        }
    var selectedSet: Int? = null
        set(value) {
            if(field != value) {
                field = value
                RecordManager.clearRecordDirectory()
            }
        }

    val testUpload: (View) -> Unit = { view ->
        /*if(RecordManager.validateRecord(collectingType)) {
            val button = AppCompatButton(view.context)
            val dialog = MaterialAlertDialogBuilder(view.context)
                .setView(button)
                .create()
            button.setOnClickListener {
                dialog.dismiss()
            }
            dialog.show()
        } else {
            showToast("녹음 미완료")
        }*/
        val button = AppCompatButton(view.context).apply{
            setBackgroundColor(Color.parseColor("#5f9595"))
            setTextColor(Color.WHITE)
            textSize = 70f
            text = "데이터 전송"
            layoutParams = ViewGroup.LayoutParams(0, 0)
        }
        val dialog = MaterialAlertDialogBuilder(view.context)
            .setView(button)
            .create()
        button.setOnClickListener {
            dialog.dismiss()
            val navController = view.findNavController()
            val navOptions = NavOptions.Builder()
                .setPopUpTo(R.id.nav_graph, true)
                .build()
            navController.navigate(R.id.mainFragment, null, navOptions)
        }
        dialog.show()
        dialog.window?.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT)
        button.updateLayoutParams {
            width = ViewGroup.LayoutParams.MATCH_PARENT
            height = 300
        }
    }
}