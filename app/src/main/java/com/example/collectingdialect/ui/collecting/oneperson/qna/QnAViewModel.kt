package com.example.collectingdialect.ui.collecting.oneperson.qna

import android.view.View
import android.widget.TextView
import androidx.databinding.Bindable
import androidx.databinding.BindingAdapter
import androidx.databinding.library.baseAdapters.BR
import com.example.collectingdialect.data.ContentData
import com.example.collectingdialect.ui.collecting.CollectingViewModel

class QnAViewModel: CollectingViewModel() {
    companion object {
        @JvmStatic
        @BindingAdapter("scriptArray", "scriptIndex", requireAll = true)
        fun setScriptIndex(view: TextView, array: Array<String>, index: Int) {
            view.text = array[index]
        }
    }

    var regionText: String = ""
        @Bindable get
        set(value) {
            if(field != value) {
                field = value
                notifyChange(com.example.collectingdialect.BR.regionText)
            }
        }

    var dialectScriptArray = ContentData.dialectScriptArray
        @Bindable get
    var dialectScriptIndex: Int = 0
        @Bindable get
        set(value) {
            if(field != value) {
                field = value
                fileName = "${userName}_script_${currentSubject}_$dialectScriptIndex"
                notifyChange(BR.dialectScriptIndex)
            }
        }
    val dialectScriptSize
        get() = dialectScriptArray.size

    var standardScriptArray = ContentData.standardScriptArray
        @Bindable get
    var standardScriptIndex: Int = 0
        @Bindable get
        set(value) {
            if(field != value) {
                field = value
                notifyChange(BR.standardScriptIndex)
            }
        }

    override fun setSubject(subject: String) {
        super.setSubject(subject)
        fileName = "${userName}_script_${currentSubject}_$dialectScriptIndex"
        //load data
        /*when(subject) {
            SubjectViewModel.SUBJECT_AGRICULTURE -> {
                currentSubject = SubjectViewModel.SUBJECT_AGRICULTURE
            }
            SubjectViewModel.SUBJECT_FAMILY -> {
                currentSubject = SubjectViewModel.SUBJECT_FAMILY
            }
            SubjectViewModel.SUBJECT_CLOTHING -> {
                currentSubject = SubjectViewModel.SUBJECT_CLOTHING
            }
            SubjectViewModel.SUBJECT_FOOD -> {
                currentSubject = SubjectViewModel.SUBJECT_FOOD
            }
            SubjectViewModel.SUBJECT_SHELTER -> {
                currentSubject = SubjectViewModel.SUBJECT_SHELTER
            }
            SubjectViewModel.SUBJECT_NATURE -> {
                currentSubject = SubjectViewModel.SUBJECT_NATURE
            }
            SubjectViewModel.SUBJECT_HEALTH -> {
                currentSubject = SubjectViewModel.SUBJECT_HEALTH
            }
            SubjectViewModel.SUBJECT_CUSTOM -> {
                currentSubject = SubjectViewModel.SUBJECT_CUSTOM
            }
            SubjectViewModel.SUBJECT_EMERGENCY -> {
                currentSubject = SubjectViewModel.SUBJECT_EMERGENCY
            }
        }*/
    }

    fun onClickPreviousButton(view: View) {
        dialectScriptIndex = if(dialectScriptIndex - 1 < 0) {
            0
        } else {
            dialectScriptIndex - 1
        }
        standardScriptIndex = if(standardScriptIndex - 1 < 0) {
            0
        } else {
            standardScriptIndex - 1
        }
    }

    fun onClickNextButton(view: View) {
        dialectScriptIndex = if(dialectScriptIndex + 1 >= dialectScriptArray.size) {
            dialectScriptIndex
        } else {
            dialectScriptIndex + 1
        }
        standardScriptIndex = if(standardScriptIndex + 1 >= standardScriptArray.size) {
            standardScriptIndex
        } else {
            standardScriptIndex + 1
        }
    }
}