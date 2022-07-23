package com.example.collectingdialect.ui.collecting.oneperson.repeat

import android.view.View
import android.widget.TextView
import androidx.databinding.Bindable
import androidx.databinding.BindingAdapter
import androidx.databinding.library.baseAdapters.BR
import androidx.navigation.findNavController
import com.example.collectingdialect.R
import com.example.collectingdialect.data.ContentData
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
        @Bindable get() = "${scriptIndex + 1} / $scriptSize"

    val dialectScriptArray = ContentData.getRepeatScriptTextDialect(RegionSelectionViewModel.REGION_GANGWON, 1)
    val standardScriptArray = ContentData.getRepeatScriptTextStandard(RegionSelectionViewModel.REGION_GANGWON, 1)
    private val scriptVoiceArray = ContentData.getRepeatScriptVoice(RegionSelectionViewModel.REGION_GANGWON, 1)
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
    val scriptSize
        get() = dialectScriptArray.size

    fun onClickPreviousButton(view: View) {
        scriptIndex = if(scriptIndex - 1 < 0) {
            0
        } else {
            scriptIndex - 1
        }
        /*standardScriptIndex = if(standardScriptIndex - 1 < 0) {
            0
        } else {
            standardScriptIndex - 1
        }*/
    }

    fun onClickNextButton(view: View) {
        scriptIndex = if(scriptIndex + 1 >= scriptSize) {
            view.findNavController().navigate(R.id.qnAFragment)
            scriptIndex
        } else {
            scriptIndex + 1
        }
        /*standardScriptIndex = if(standardScriptIndex + 1 >= standardScriptArray.size) {
            standardScriptIndex
        } else {
            standardScriptIndex + 1
        }*/
    }

    fun onClickPlayScriptButton(view: View) {
        playScript(view.context, scriptVoiceArray[scriptIndex])
    }
}