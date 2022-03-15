package com.example.collectingdialect.ui.collecting.objectname

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.View
import androidx.core.content.res.ResourcesCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.example.collectingdialect.R
import com.example.collectingdialect.databinding.FragmentCollectingObjectNameBinding

class CollectingObjectNameFragment: Fragment(R.layout.fragment_collecting_object_name) {
    private var binding: FragmentCollectingObjectNameBinding? = null
    private val viewModel: CollectingObjectNameViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if(binding == null) {
            binding = DataBindingUtil.bind(view)
            binding?.viewModel = viewModel

            var drawable: Drawable?
            val imageList = arrayListOf<Drawable>()
            drawable = ResourcesCompat.getDrawable(resources, R.drawable.pumpkin, null)
            if(drawable != null) {
                imageList.add(drawable)
            }
            drawable = ResourcesCompat.getDrawable(resources, R.drawable.scissors, null)
            if(drawable != null) {
                imageList.add(drawable)
            }
            drawable = ResourcesCompat.getDrawable(resources, R.drawable.toilet_paper, null)
            if(drawable != null) {
                imageList.add(drawable)
            }

            viewModel.imageList.addAll(imageList)
            binding?.objectImage?.let {
                Glide.with(this).load(imageList[0]).into(it)
                viewModel.position.set(0)
            }
        }
    }
}