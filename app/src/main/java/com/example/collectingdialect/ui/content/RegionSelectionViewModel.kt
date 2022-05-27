package com.example.collectingdialect.ui.content

import android.view.View
import androidx.navigation.findNavController
import com.example.collectingdialect.R
import com.example.collectingdialect.ui.BaseViewModel

class RegionSelectionViewModel: BaseViewModel() {
    val dummyList = arrayListOf("강원 (영동)", "강원 (영서)", "경상 (대구/경북)", "경상 (부산/경남)", "충청 (충북)", "충청 (충남)", "전라 (전북)", "전라 (전남)", "제주")

    override fun onClickNextButton(view: View) {
        super.onClickNextButton(view)
        view.findNavController().navigate(R.id.contentFragment)
    }

    override fun onClickPreviousButton(view: View) {
        super.onClickPreviousButton(view)
        view.findNavController().popBackStack()
    }
}