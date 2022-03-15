package com.example.collectingdialect.ui.collecting.freetalk

import android.graphics.drawable.Drawable
import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.collectingdialect.ui.collecting.CollectingViewModel
import java.util.concurrent.atomic.AtomicInteger

class CollectingFreeTalkViewModel: CollectingViewModel() {
    val imageList = arrayListOf<Drawable>()
    val position = AtomicInteger(-1)


    fun onClickPreviousImageButton(view: View, imageView: ImageView) {
        val newPosition = position.updateAndGet {
            if(it - 1 > -1) {
                it - 1
            } else {
                it
            }
        }
        Glide.with(imageView).load(imageList[newPosition]).into(imageView)
    }

    fun onClickNextImageButton(view: View, imageView: ImageView) {
        val newPosition = position.updateAndGet {
            if(it + 1 < imageList.size) {
                it + 1
            } else {
                it
            }
        }
        Glide.with(imageView).load(imageList[newPosition]).into(imageView)
    }
}