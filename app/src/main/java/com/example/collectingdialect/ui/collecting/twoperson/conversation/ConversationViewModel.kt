package com.example.collectingdialect.ui.collecting.twoperson.conversation

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Matrix
import android.graphics.drawable.Drawable
import android.view.View
import android.view.ViewGroup
import android.view.ViewTreeObserver
import android.widget.ImageView
import androidx.core.graphics.drawable.toDrawable
import androidx.core.view.updateLayoutParams
import androidx.databinding.Bindable
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.Transformation
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.load.engine.Resource
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.example.collectingdialect.BR
import com.example.collectingdialect.R
import com.example.collectingdialect.data.ContentData
import com.example.collectingdialect.ui.MainActivity.Companion.showToast
import com.example.collectingdialect.ui.SharedViewModel
import com.example.collectingdialect.ui.collecting.CollectingViewModel
import com.example.collectingdialect.ui.collecting.RecordAdapter
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import java.security.MessageDigest

class ConversationViewModel: CollectingViewModel() {
    var sharedViewModel: SharedViewModel? = null
    var regionText: String = ""
        @Bindable get
        set(value) {
            if(field != value) {
                field = value
                notifyChange(BR.regionText)
            }
        }

    val contentSequence: String
        @Bindable get() = if(arraySize > 0) {
            "${index + 1} / $arraySize"
        } else {
            ""
        }

    var imageArray: Array<Int> = arrayOf()
    var scriptArray: Array<String> = arrayOf()
    var index = 0
        @Bindable get
        set(value) {
            if(field != value) {
                field = value
                fileNamePrefix = "conversation_${index}"
                fileName = "conversation_${index}_${adapter.itemCount}"
                notifyChange(BR.index)
                notifyChange(BR.contentSequence)
            }
        }
    private val arraySize
        get() = imageArray.size

    var adapter = RecordAdapter {this}
    var fileNamePrefix: String = ""
        set(value) {
            field = value
            adapter.requestRecordList(fileNamePrefix)
        }

    init {
        fileNamePrefix = "conversation_${index}"
        fileName = "conversation_${index}_${adapter.itemCount}"
    }

    fun initializeWithSharedViewModel(sharedViewModel: SharedViewModel?) {
        this.sharedViewModel = sharedViewModel
        val selectedRegion = sharedViewModel?.currentSpeakerInfo?.residenceProvince
        val selectedSet = sharedViewModel?.selectedSet
        regionText = selectedRegion ?: ""
        imageArray = ContentData.getConversationImage(selectedSet)
        scriptArray = ContentData.getConversationScriptText(selectedRegion, selectedSet)
    }

    fun onClickImage(view: View) {
        val image = BitmapFactory.decodeResource(view.resources, imageArray[index])
        var isLandScapeDialog = false
        val imageWidth = image.width
        val imageHeight = image.height
        if(imageWidth > imageHeight) {
            isLandScapeDialog = true
        }
        val imageView = ImageView(view.context).apply {
            layoutParams = ViewGroup.LayoutParams(0, 0)
        }
        val dialog = MaterialAlertDialogBuilder(view.context)
            .create()
        dialog.setOnShowListener {
            dialog.window?.apply {
                setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
                setDimAmount(0.6f)
            }
        }
        dialog.show()
        val decorView = dialog.window?.decorView ?: return
        var onAfterDecorViewLayout: (() -> Unit)? = null
        var decorViewWidth = 0
        val decorViewLayoutListener = ViewTreeObserver.OnGlobalLayoutListener {
            decorViewWidth = decorView.width
            onAfterDecorViewLayout?.invoke()
        }
        onAfterDecorViewLayout = {
            decorView.viewTreeObserver.removeOnGlobalLayoutListener(decorViewLayoutListener)

            val adjustedViewWidth: Int
            val adjustedViewHeight: Int
            if(isLandScapeDialog) {
                adjustedViewWidth = imageWidth * decorViewWidth / imageHeight
                adjustedViewHeight = decorViewWidth
            } else {
                adjustedViewWidth = decorViewWidth
                adjustedViewHeight = imageHeight * decorViewWidth / imageWidth
            }
            imageView.updateLayoutParams {
                width = adjustedViewWidth
                height = adjustedViewHeight
            }
            Glide.with(imageView).load(imageArray[index]).addListener(object:RequestListener<Drawable>{
                override fun onLoadFailed(
                    e: GlideException?,
                    model: Any?,
                    target: Target<Drawable>?,
                    isFirstResource: Boolean
                ): Boolean {
                    return true
                }

                override fun onResourceReady(
                    resource: Drawable?,
                    model: Any?,
                    target: Target<Drawable>?,
                    dataSource: DataSource?,
                    isFirstResource: Boolean
                ): Boolean {
                    if(resource != null) {
                        decorView.background = resource
                    }
                    return true
                }
            }).into(imageView)
        }
        decorView.viewTreeObserver?.addOnGlobalLayoutListener(decorViewLayoutListener)
    }

    fun onClickPreviousButton(view: View) {
        index = if(index - 1 < 0) {
            0
        } else {
            index - 1
        }
    }

    fun onClickNextButton(view: View) {
        index = if(index + 1 >= arraySize) {
            sharedViewModel?.testUpload?.invoke(view)
            index
        } else {
            index + 1
        }
    }

    override fun onClickRecordButton(view: View) {
        if(!isRecording) {
            fileName = "conversation_${index}_${adapter.itemCount}"
        }
        val recordCallback = {adapter.requestRecordList(fileNamePrefix)}
        super.onClickRecordButton(view, recordCallback)
    }

    fun onClickTempButton(view: View) {
        sharedViewModel?.testUpload?.invoke(view)
    }
}