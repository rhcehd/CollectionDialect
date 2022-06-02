package com.example.collectingdialect.ui.collecting.unstructured.virtual

import android.view.View
import androidx.navigation.findNavController
import com.example.collectingdialect.ui.collecting.CollectingViewModel

class VirtualPartnerViewModel: CollectingViewModel() {

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