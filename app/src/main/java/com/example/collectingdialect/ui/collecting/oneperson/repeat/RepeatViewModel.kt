package com.example.collectingdialect.ui.collecting.oneperson.repeat

import android.view.View
import android.widget.TextView
import androidx.databinding.Bindable
import androidx.databinding.BindingAdapter
import androidx.databinding.library.baseAdapters.BR
import androidx.navigation.findNavController
import com.example.collectingdialect.R
import com.example.collectingdialect.data.ContentData
import com.example.collectingdialect.ui.SharedViewModel
import com.example.collectingdialect.ui.collecting.CollectingViewModel
import com.example.collectingdialect.ui.content.region.RegionSelectionViewModel

class RepeatViewModel: CollectingViewModel() {
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

    var dialectScriptArray: Array<String> = arrayOf()
    var standardScriptArray: Array<String> = arrayOf()
    private var scriptVoiceArray: Array<Int> = arrayOf()
    var scriptIndex: Int = 0
        @Bindable get
        set(value) {
            if(field != value) {
                field = value
                fileName = "repeat_$scriptIndex"
                notifyChange(BR.scriptIndex)
                notifyChange(BR.contentSequence)
            }
        }
    private val scriptSize
        get() = dialectScriptArray.size

    fun initializeWithSharedViewModel(sharedViewModel: SharedViewModel?) {
        val selectedRegion = sharedViewModel?.currentSpeakerInfo?.residenceProvince
        val selectedSet = sharedViewModel?.selectedSet
        regionText = selectedRegion ?: ""
        dialectScriptArray = ContentData.getRepeatScriptTextDialect(selectedRegion, selectedSet)
        standardScriptArray = ContentData.getRepeatScriptTextStandard(selectedRegion, selectedSet)
        scriptVoiceArray = ContentData.getRepeatScriptVoice(selectedRegion, selectedSet)
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
            view.findNavController().navigate(R.id.qnAFragment)
            scriptIndex
        } else {
            scriptIndex + 1
        }
    }

    fun onClickPlayScriptButton(view: View) {
        playScript(view.context, scriptVoiceArray[scriptIndex])
    }

    fun onClickTempButton(view: View) {
        view.findNavController().navigate(R.id.qnAFragment)
    }
}