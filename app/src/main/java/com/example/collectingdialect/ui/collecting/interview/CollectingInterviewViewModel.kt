package com.example.collectingdialect.ui.collecting.interview

import android.view.View
import androidx.databinding.Bindable
import androidx.databinding.library.baseAdapters.BR
import com.example.collectingdialect.ui.collecting.CollectingViewModel

class CollectingInterviewViewModel: CollectingViewModel() {
    var isQuestion1Selected: Boolean = false
    @Bindable get
    set(value) {
        if(field != value) {
            field = value
            isQuestion1Completed = true
            notifyChange(BR.question1Selected)
        }
    }

    var isQuestion1Completed: Boolean = false
        @Bindable get
        set(value) {
            if(field != value) {
                field = value
            }
        }

    var isQuestion2Selected: Boolean = false
        @Bindable get
        set(value) {
            if(field != value) {
                field = value
                isQuestion2Completed = true
                notifyChange(BR.question2Selected)
            }
        }

    var isQuestion2Completed: Boolean = false
        @Bindable get
        set(value) {
            if(field != value) {
                field = value
            }
        }

    var isQuestion3Selected: Boolean = false
        @Bindable get
        set(value) {
            if(field != value) {
                field = value
                isQuestion3Completed = true
                notifyChange(BR.question3Selected)
            }
        }

    var isQuestion3Completed: Boolean = false
        @Bindable get
        set(value) {
            if(field != value) {
                field = value
            }
        }

    var isQuestion4Selected: Boolean = false
        @Bindable get
        set(value) {
            if(field != value) {
                field = value
                isQuestion4Completed = true
                notifyChange(BR.question4Selected)
            }
        }

    var isQuestion4Completed: Boolean = false
        @Bindable get
        set(value) {
            if(field != value) {
                field = value
            }
        }

    var isQuestion5Selected: Boolean = false
        @Bindable get
        set(value) {
            if(field != value) {
                field = value
                isQuestion5Completed = true
                notifyChange(BR.question5Selected)
            }
        }

    var isQuestion5Completed: Boolean = false
        @Bindable get
        set(value) {
            if(field != value) {
                field = value
            }
        }

    fun onClickQuestion1(view: View) {
        isQuestion1Selected = true
        isQuestion2Selected = false
        isQuestion3Selected = false
        isQuestion4Selected = false
        isQuestion5Selected = false
    }

    fun onClickQuestion2(view: View) {
        isQuestion2Selected = true
        isQuestion1Selected = false
        isQuestion3Selected = false
        isQuestion4Selected = false
        isQuestion5Selected = false
    }

    fun onClickQuestion3(view: View) {
        isQuestion3Selected = true
        isQuestion1Selected = false
        isQuestion2Selected = false
        isQuestion4Selected = false
        isQuestion5Selected = false
    }

    fun onClickQuestion4(view: View) {
        isQuestion4Selected = true
        isQuestion1Selected = false
        isQuestion2Selected = false
        isQuestion3Selected = false
        isQuestion5Selected = false
    }

    fun onClickQuestion5(view: View) {
        isQuestion5Selected = true
        isQuestion1Selected = false
        isQuestion2Selected = false
        isQuestion3Selected = false
        isQuestion4Selected = false
    }
}