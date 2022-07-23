package com.example.collectingdialect.ui.collecting.oneperson.qna

import android.view.View
import android.widget.TextView
import androidx.databinding.Bindable
import androidx.databinding.BindingAdapter
import androidx.databinding.library.baseAdapters.BR
import com.example.collectingdialect.data.ContentData
import com.example.collectingdialect.ui.MainActivity.Companion.showToast
import com.example.collectingdialect.ui.collecting.CollectingViewModel

class QnAViewModel: CollectingViewModel() {
    var regionText: String = ""
        @Bindable get
        set(value) {
            if(field != value) {
                field = value
                notifyChange(com.example.collectingdialect.BR.regionText)
            }
        }

    val contentSequence: String
        @Bindable get() = "${scriptIndex + 1} / $scriptSize"

    var dialectScriptArray = arrayOf<String>()
    var standardScriptArray = arrayOf<String>()
    var scriptIndex: Int = 0
        @Bindable get
        set(value) {
            if(field != value) {
                field = value
                fileName = "qna_$scriptIndex"
                notifyChange(BR.scriptIndex)
                notifyChange(BR.contentSequence)
            }
        }
    private val scriptSize
        get() = dialectScriptArray.size

    fun onClickPreviousButton(view: View) {
        scriptIndex = if(scriptIndex - 1 < 0) {
            0
        } else {
            scriptIndex - 1
        }
    }

    fun onClickNextButton(view: View) {
        scriptIndex = if(scriptIndex + 1 >= scriptSize) {
            showToast("lastItem")
            scriptIndex
        } else {
            scriptIndex + 1
        }
    }
}