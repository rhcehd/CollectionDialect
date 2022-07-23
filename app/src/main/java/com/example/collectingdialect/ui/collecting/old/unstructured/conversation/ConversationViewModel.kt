package com.example.collectingdialect.ui.collecting.old.unstructured.conversation

import android.view.View
import android.widget.ImageView
import androidx.databinding.Bindable
import androidx.databinding.BindingAdapter
import androidx.navigation.findNavController
import com.example.collectingdialect.BR
import com.example.collectingdialect.data.ContentData
import com.example.collectingdialect.ui.collecting.CollectingViewModel
import com.example.collectingdialect.ui.collecting.RecordAdapter

class ConversationViewModel: CollectingViewModel() {
    companion object {
        @JvmStatic
        @BindingAdapter("conversationArray", "conversationIndex", requireAll = true)
        fun setScriptIndex(view: ImageView, array: Array<Int>, index: Int) {
            view.setImageResource(array[index])
        }
    }

    var regionText: String = ""
        @Bindable get
        set(value) {
            if(field != value) {
                field = value
                notifyChange(BR.regionText)
            }
        }

    var imageArray = ContentData.imageArray
        @Bindable get
    var imageIndex = 0
        @Bindable get
        set(value) {
            if(field != value) {
                field = value
                fileNamePrefix = "${userName}_conversation_${currentSubject}_${imageIndex}"
                fileName = "${userName}_conversation_${currentSubject}_${imageIndex}_${adapter.itemCount}"
                notifyChange(BR.imageIndex)
            }
        }
    val imageArraySize
        get() = imageArray.size

    var adapter = RecordAdapter {this}
    var fileNamePrefix: String = ""
        set(value) {
            field = value
            adapter.requestRecordList(fileNamePrefix)
        }

    override fun setSubject(subject: String) {
        super.setSubject(subject)
        fileNamePrefix = "${userName}_conversation_${currentSubject}_${imageIndex}"
        fileName = "${userName}_conversation_${currentSubject}_${imageIndex}_${adapter.itemCount}"
    }

    fun onClickBackButton(view: View) {
        view.findNavController().popBackStack()
    }

    fun onClickPreviousButton(view: View) {
        imageIndex = if(imageIndex - 1 < 0) {
            0
        } else {
            imageIndex - 1
        }
    }

    fun onClickNextButton(view: View) {
        imageIndex = if(imageIndex + 1 >= imageArray.size) {
            imageIndex
        } else {
            imageIndex + 1
        }
    }

    override fun onClickRecordButton(view: View) {
        if(!isRecording) {
            fileName = "${userName}_conversation_${currentSubject}_${imageIndex}_${adapter.itemCount}"
        }
        val recordCallback = {adapter.requestRecordList(fileNamePrefix)}
        super.onClickRecordButton(view, recordCallback)
    }
}