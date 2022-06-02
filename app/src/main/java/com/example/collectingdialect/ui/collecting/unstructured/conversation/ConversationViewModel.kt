package com.example.collectingdialect.ui.collecting.unstructured.conversation

import android.view.View
import androidx.navigation.findNavController
import com.example.collectingdialect.ui.BaseViewModel
import com.example.collectingdialect.ui.collecting.CollectingViewModel

class ConversationViewModel: CollectingViewModel() {

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