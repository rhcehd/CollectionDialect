package com.example.collectingdialect.ui.collecting.oneperson.qna

import android.view.View
import androidx.databinding.Bindable
import androidx.databinding.library.baseAdapters.BR
import androidx.navigation.findNavController
import com.example.collectingdialect.data.ContentData
import com.example.collectingdialect.ui.SharedViewModel
import com.example.collectingdialect.ui.collecting.CollectingViewModel

class QnAViewModel: CollectingViewModel() {
    var isOver50YearsOld = false
        @Bindable get
        set(value) {
            if(field != value) {
                field = value
                notifyChange(BR.over50YearsOld)
            }
        }

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
                firstIndex = "$scriptIndex"
                notifyChange(BR.scriptIndex)
                notifyChange(BR.contentSequence)
            }
        }
    private val scriptSize
        get() = ScriptArray.size

    override fun initializeWithSharedViewModel(sharedViewModel: SharedViewModel) {
        val collectorBirthYear = sharedViewModel.collectorBirthYear ?: 9999
        isOver50YearsOld = if(collectorBirthYear <= 1972) {
            isConversationType = true
            contentName = CONTENT_NAME_CONVERSATION
            true
        } else {
            contentName = CONTENT_NAME_QNA
            false
        }

        val selectedRegion = sharedViewModel.currentSpeaker1Info?.residenceProvince
        val selectedSet = sharedViewModel.selectedSet
        regionText = selectedRegion ?: ""
        ScriptArray = ContentData.getQnAScriptText(selectedSet)

        setName = "set${selectedSet ?: 0}"
        firstIndex = "$scriptIndex"
        adapterEnabled = true

        super.initializeWithSharedViewModel(sharedViewModel)
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
            scriptIndex
        } else {
            scriptIndex + 1
        }
    }

    fun onClickPreviousPartButton(view: View) {
        view.findNavController().popBackStack()
    }
}