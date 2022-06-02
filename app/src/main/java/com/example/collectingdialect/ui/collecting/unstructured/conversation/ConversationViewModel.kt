package com.example.collectingdialect.ui.collecting.unstructured.conversation

import android.view.View
import androidx.databinding.Bindable
import androidx.navigation.findNavController
import com.example.collectingdialect.BR
import com.example.collectingdialect.ui.BaseViewModel
import com.example.collectingdialect.ui.collecting.CollectingViewModel

class ConversationViewModel: CollectingViewModel() {

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

    fun onClickRecordConversation1Button(view: View) {
        fileName = "test_conversation_${currentSubject}_0"
        onClickRecordButton(view)
    }

    fun onClickPlayConversation1Button(view: View) {
        fileName = "test_conversation_${currentSubject}_0"
        onClickPlayButton(view)
    }
}