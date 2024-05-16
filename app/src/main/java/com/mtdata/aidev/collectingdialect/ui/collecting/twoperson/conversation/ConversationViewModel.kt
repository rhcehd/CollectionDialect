package com.mtdata.aidev.collectingdialect.ui.collecting.twoperson.conversation

import android.graphics.BitmapFactory
import android.graphics.drawable.Drawable
import android.view.View
import android.view.ViewGroup
import android.view.ViewTreeObserver
import android.widget.ImageView
import androidx.core.view.updateLayoutParams
import androidx.databinding.Bindable
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.mtdata.aidev.collectingdialect.BR
import com.mtdata.aidev.collectingdialect.data.ContentData
import com.mtdata.aidev.collectingdialect.ui.SharedViewModel
import com.mtdata.aidev.collectingdialect.ui.collecting.CollectingViewModel
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
                onChangeUIState()
                firstIndex = "$index"
                notifyChange(BR.index)
                notifyChange(BR.contentSequence)
            }
        }
    private val arraySize
        get() = imageArray.size

    init {
        isConversationType = true
        adapterEnabled = true
    }

    override fun initializeWithSharedViewModel(sharedViewModel: SharedViewModel) {
        val selectedRegion = sharedViewModel.currentSpeaker1Info?.residenceProvince
        val selectedSet = sharedViewModel.selectedSet
        regionText = selectedRegion ?: ""
        imageArray = ContentData.getConversationImage(selectedSet)
        scriptArray = ContentData.getConversationScriptText(selectedSet)

        contentName = CONTENT_NAME_CONVERSATION
        setName = "set${selectedSet ?: 0}"
        firstIndex = "$index"

        super.initializeWithSharedViewModel(sharedViewModel)
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
                    target: Target<Drawable>,
                    isFirstResource: Boolean
                ): Boolean = true

                override fun onResourceReady(
                    resource: Drawable,
                    model: Any,
                    target: Target<Drawable>?,
                    dataSource: DataSource,
                    isFirstResource: Boolean
                ): Boolean {
                    decorView.background = resource
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
            index
        } else {
            index + 1
        }
    }
}