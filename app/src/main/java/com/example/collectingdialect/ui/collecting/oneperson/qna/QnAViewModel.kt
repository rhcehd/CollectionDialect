package com.example.collectingdialect.ui.collecting.oneperson.qna

import android.view.View
import androidx.databinding.Bindable
import androidx.databinding.library.baseAdapters.BR
import com.example.collectingdialect.data.ContentData
import com.example.collectingdialect.ui.MainActivity.Companion.showToast
import com.example.collectingdialect.ui.SharedViewModel
import com.example.collectingdialect.ui.collecting.CollectingViewModel

class QnAViewModel: CollectingViewModel() {
    var sharedViewModel: SharedViewModel? = null
    var regionText: String = ""
        @Bindable get
        set(value) {
            if(field != value) {
                field = value
                notifyChange(BR.regionText)
            }
        }

    val contentSequence: String
        @Bindable get() = if(scriptSize > 0) {
            "${scriptIndex + 1} / $scriptSize"
        } else {
            ""
        }

    var ScriptArray: Array<String> = arrayOf()
    var scriptIndex: Int = 0
        @Bindable get
        set(value) {
            if(field != value) {
                field = value
                onChangeUIState()
                fileName = "qna_$scriptIndex"
                notifyChange(BR.scriptIndex)
                notifyChange(BR.contentSequence)
            }
        }
    private val scriptSize
        get() = ScriptArray.size

    init {
        fileName = "qna_$scriptIndex"
    }

    fun initializeWithSharedViewModel(sharedViewModel: SharedViewModel?) {
        this.sharedViewModel = sharedViewModel
        val selectedRegion = sharedViewModel?.currentSpeakerInfo?.residenceProvince
        val selectedSet = sharedViewModel?.selectedSet
        regionText = selectedRegion ?: ""
        ScriptArray = ContentData.getQnAScriptText(selectedRegion, selectedSet)
    }

    fun onClickPreviousButton(view: View) {
        scriptIndex = if(scriptIndex - 1 < 0) {
            0
        } else {
            scriptIndex - 1
        }
    }

    fun onClickNextButton(view: View) {
        scriptIndex = if(scriptIndex + 1 >= scriptSize) {
            sharedViewModel?.testUpload?.invoke(view)
            scriptIndex
        } else {
            scriptIndex + 1
        }
    }

    fun onClickTempButton(view: View) {
        sharedViewModel?.testUpload?.invoke(view)
    }
}