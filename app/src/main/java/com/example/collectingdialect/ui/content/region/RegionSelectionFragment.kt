package com.example.collectingdialect.ui.content.region

import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewTreeObserver
import androidx.core.os.bundleOf
import androidx.core.view.updateLayoutParams
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.collectingdialect.R
import com.example.collectingdialect.databinding.FragmentRegionSelectionBinding

class RegionSelectionFragment: Fragment(R.layout.fragment_region_selection) {
    private var binding: FragmentRegionSelectionBinding? = null
    private val viewModel: RegionSelectionViewModel by viewModels()

    private val globalLayoutListener = ViewTreeObserver.OnGlobalLayoutListener {
        binding?.apply {
            val imageViewWidth = regionImage.width
            val imageViewHeight = regionImage.height
            val bitmapWidth = (regionImage.drawable as BitmapDrawable).bitmap.width
            val bitmapHeight = (regionImage.drawable as BitmapDrawable).bitmap.height
            val imageWidth = if(imageViewHeight * bitmapWidth <= imageViewWidth * bitmapHeight) {
                bitmapWidth * imageViewHeight / bitmapHeight
            } else {
                imageViewWidth
            }
            val imageHeight = if(imageViewHeight * bitmapWidth <= imageViewWidth * bitmapHeight) {
                imageViewHeight
            } else {
                bitmapHeight * imageViewWidth / bitmapWidth
            }
            selectAreaLayout.updateLayoutParams {
                width = imageWidth
                height = imageHeight
            }

            val selectAreaWidth = (imageWidth * 0.1).toInt()
            val selectAreaHeight = (imageHeight * 0.12).toInt()

            selectAreaGangwon.updateLayoutParams {
                width = selectAreaWidth
                height = selectAreaHeight
            }
            selectAreaChungnam.updateLayoutParams {
                width = selectAreaWidth
                height = selectAreaHeight
            }
            selectAreaChungbuk.updateLayoutParams {
                width = selectAreaWidth
                height = selectAreaHeight
            }
            selectAreaGyeongnam.updateLayoutParams {
                width = selectAreaWidth
                height = selectAreaHeight
            }
            selectAreaGyeongbuk.updateLayoutParams {
                width = selectAreaWidth
                height = selectAreaHeight
            }
            selectAreaJeonnam.updateLayoutParams {
                width = selectAreaWidth
                height = selectAreaHeight
            }
            selectAreaJeonbuk.updateLayoutParams {
                width = selectAreaWidth
                height = selectAreaHeight
            }
            selectAreaJeju.updateLayoutParams {
                width = selectAreaWidth
                height = selectAreaHeight
            }
            onCompleteGlobalLayout()
        }
    }

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
            binding?.apply {
                viewModel = this@RegionSelectionFragment.viewModel
                root.viewTreeObserver.addOnGlobalLayoutListener(globalLayoutListener)
            }
            viewModel.regionSelectResultCallback = { selectedRegion: String ->
                setFragmentResult(RegionSelectionViewModel.KEY_REGION, bundleOf(RegionSelectionViewModel.KEY_REGION to selectedRegion))
                findNavController().popBackStack()
            }
        }
    }

    private fun onCompleteGlobalLayout() {
        binding?.root?.viewTreeObserver?.removeOnGlobalLayoutListener(globalLayoutListener)
    }
}