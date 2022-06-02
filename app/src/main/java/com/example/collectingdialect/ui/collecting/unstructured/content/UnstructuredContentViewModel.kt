package com.example.collectingdialect.ui.collecting.unstructured.content

import android.view.View
import androidx.navigation.findNavController
import com.example.collectingdialect.R
import com.example.collectingdialect.ui.BaseViewModel

class UnstructuredContentViewModel: BaseViewModel() {

    fun onClickSituationSpeakButton(view: View) {

    }

    fun onClick2pConversationSpeakButton(view: View) {
        view.findNavController().navigate(R.id.conversationSubjectFragment)
    }

    fun onClickVirtualPartnerSpeakButton(view: View) {
        view.findNavController().navigate(R.id.virtualPartnerSubjectFragment)
    }
}