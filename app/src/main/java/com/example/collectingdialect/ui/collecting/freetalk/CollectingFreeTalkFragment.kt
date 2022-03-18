package com.example.collectingdialect.ui.collecting.freetalk

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.example.collectingdialect.R
import com.example.collectingdialect.databinding.FragmentCollectingFreeTalkBinding

class CollectingFreeTalkFragment: Fragment(R.layout.fragment_collecting_free_talk) {
    private var binding: FragmentCollectingFreeTalkBinding? = null
    private val viewModel: CollectingFreeTalkViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding?.root ?: super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if(binding == null) {
            binding = DataBindingUtil.bind(view)
            binding?.viewModel = viewModel

            var drawable: Drawable?
            val imageList = arrayListOf<Drawable>()
            drawable = ResourcesCompat.getDrawable(resources, R.drawable.flat_tire, null)
            if(drawable != null) {
                imageList.add(drawable)
            }
            drawable = ResourcesCompat.getDrawable(resources, R.drawable.highway, null)
            if(drawable != null) {
                imageList.add(drawable)
            }
            drawable = ResourcesCompat.getDrawable(resources, R.drawable.corner_ball, null)
            if(drawable != null) {
                imageList.add(drawable)
            }

            viewModel.imageList.addAll(imageList)
            binding?.freeTalkImage?.let {
                Glide.with(this).load(imageList[0]).into(it)
                viewModel.position.set(0)
            }
        }
    }
}