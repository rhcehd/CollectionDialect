package com.example.collectingdialect.ui.collecting.twoperson.conversation

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Matrix
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.graphics.drawable.toDrawable
import androidx.databinding.Bindable
import androidx.databinding.BindingAdapter
import com.example.collectingdialect.BR
import com.example.collectingdialect.R
import com.example.collectingdialect.data.ContentData
import com.example.collectingdialect.ui.MainActivity.Companion.showToast
import com.example.collectingdialect.ui.collecting.CollectingViewModel
import com.example.collectingdialect.ui.collecting.RecordAdapter
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class ConversationViewModel: CollectingViewModel() {
    var regionText: String = ""
        @Bindable get
        set(value) {
            if(field != value) {
                field = value
                notifyChange(BR.regionText)
            }
        }

    var imageArray = arrayOf<Int>()
    var imageIndex = 0
        @Bindable get
        set(value) {
            if(field != value) {
                field = value
                fileNamePrefix = "conversation_${imageIndex}"
                fileName = "conversation_${imageIndex}_${adapter.itemCount}"
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

    init {
        fileNamePrefix = "conversation_${imageIndex}"
        fileName = "conversation_${imageIndex}_${adapter.itemCount}"
    }

    fun onClickImage(view: View) {
        var image = BitmapFactory.decodeResource(view.resources, imageArray[imageIndex])
        if(image.width > image.height) {
            val matrix = Matrix().apply { postRotate(90.0f) }
            image = Bitmap.createBitmap(image, 0, 0, image.width, image.height, matrix, false)
            image = Bitmap.createScaledBitmap(image, image.width, image.height, false)
        }
        val imageView = ImageView(view.context)
        imageView.setImageBitmap(image)
        //val dialog = AlertDialog.Builder(view.context, R.style.EmptyDialog)
        val dialog = MaterialAlertDialogBuilder(view.context, R.style.EmptyDialog)
            //.setView(imageView)
            .setBackground(image.toDrawable(view.resources))
            .create()
        dialog.setOnShowListener {
            dialog.window?.apply {
                setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
                setDimAmount(0.6f)
            }
        }
        dialog.show()
        /*dialog.window?.apply {
            setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
            //setDimAmount(0.6f)
        }*/
    }

    fun onClickPreviousButton(view: View) {
        imageIndex = if(imageIndex - 1 < 0) {
            0
        } else {
            imageIndex - 1
        }
    }

    fun onClickNextButton(view: View) {
        imageIndex = if(imageIndex + 1 >= imageArraySize) {
            showToast("last item")
            imageIndex
        } else {
            imageIndex + 1
        }
    }

    override fun onClickRecordButton(view: View) {
        if(!isRecording) {
            fileName = "conversation_${imageIndex}_${adapter.itemCount}"
        }
        val recordCallback = {adapter.requestRecordList(fileNamePrefix)}
        super.onClickRecordButton(view, recordCallback)
    }
}