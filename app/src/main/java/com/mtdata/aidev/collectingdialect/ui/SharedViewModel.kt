package com.mtdata.aidev.collectingdialect.ui

import androidx.databinding.Bindable
import com.mtdata.aidev.collectingdialect.BR
import com.mtdata.aidev.collectingdialect.data.SpeakerInfo

class SharedViewModel: BaseViewModel() {
    var collectorId: String? = null
        @Bindable get
        set(value) {
            if(field != value) {
                field = value
                notifyChange(BR.collectorId)
            }
        }
    var collectorBirthYear: Int? = null
    var currentSpeaker1Info: SpeakerInfo? = null
        set(value) {
            if(field?.equals(value) != true) {
                field = value
            }
        }
    var currentSpeaker2Info: SpeakerInfo? = null
        set(value) {
            if(field?.equals(value) != true) {
                field = value
            }
        }
    var selectedContent: Int? = null
        set(value) {
            if(field != value) {
                field = value
            }
        }
    var selectedSet: Int? = null
        set(value) {
            if(field != value) {
                field = value
            }
        }
}