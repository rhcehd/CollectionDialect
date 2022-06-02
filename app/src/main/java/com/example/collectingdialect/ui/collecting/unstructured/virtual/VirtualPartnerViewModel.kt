package com.example.collectingdialect.ui.collecting.unstructured.virtual

import android.view.View
import androidx.databinding.Bindable
import androidx.navigation.findNavController
import com.example.collectingdialect.BR
import com.example.collectingdialect.ui.collecting.CollectingViewModel

class VirtualPartnerViewModel: CollectingViewModel() {

    var regionText: String = ""
        @Bindable get
        set(value) {
            if(field != value) {
                field = value
                notifyChange(BR.regionText)
            }
        }

    fun onClickBackButton(view: View) {
        view.findNavController().popBackStack()
    }

    fun onClickRecordVirtualPartner1Button(view: View) {
        fileName = "test_virtual_partner_${currentSubject}_0"
        onClickRecordButton(view)
    }

    fun onClickPlayVirtualPartner1Button(view: View) {
        fileName = "test_virtual_partner_${currentSubject}_0"
        onClickPlayButton(view)
    }
}