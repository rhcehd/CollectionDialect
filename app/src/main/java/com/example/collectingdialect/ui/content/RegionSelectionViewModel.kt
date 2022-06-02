package com.example.collectingdialect.ui.content

import android.content.Context
import android.view.View
import android.widget.ImageView
import androidx.core.os.bundleOf
import androidx.databinding.Bindable
import androidx.databinding.BindingAdapter
import androidx.navigation.findNavController
import com.example.collectingdialect.BR
import com.example.collectingdialect.R
import com.example.collectingdialect.ui.BaseViewModel
import com.example.collectingdialect.ui.MainActivity.Companion.showToast

class RegionSelectionViewModel: BaseViewModel() {
    companion object {
        @JvmStatic
        @BindingAdapter("region")
        fun selectRegion(view: ImageView, region: String) {
            when(region) {
                REGION_NO_SELECT -> view.setImageResource(R.drawable.region_no_select)
                REGION_GANGWON -> view.setImageResource(R.drawable.region_select_gangwon)
                REGION_CHUNGNAM -> view.setImageResource(R.drawable.region_select_chungnam)
                REGION_CHUNGBUK -> view.setImageResource(R.drawable.region_select_chungbuk)
                REGION_GYEONGNAM -> view.setImageResource(R.drawable.region_select_gyeongnam)
                REGION_GYEONGBUK -> view.setImageResource(R.drawable.region_select_gyeongbuk)
                REGION_JEONNAM -> view.setImageResource(R.drawable.region_select_jeonnam)
                REGION_JEONBUK -> view.setImageResource(R.drawable.region_select_jeonbuk)
                REGION_JEJU -> view.setImageResource(R.drawable.region_select_jeju)
            }
        }

        const val KEY_REGION = "region"
        const val REGION_NO_SELECT = "no_select"
        const val REGION_GANGWON = "강원 방언"
        const val REGION_CHUNGNAM = "충청(충남,대전,세종) 방언"
        const val REGION_CHUNGBUK = "충청(충북) 방언"
        const val REGION_GYEONGNAM = "경상(경남,부산,울산) 방언"
        const val REGION_GYEONGBUK = "경상(경북,대구) 방언"
        const val REGION_JEONNAM = "전라(전남,광주) 방언"
        const val REGION_JEONBUK = "전라(전북) 방언"
        const val REGION_JEJU = "제주 방언"
    }

    var region: String = REGION_NO_SELECT
        @Bindable get
        set(value) {
            if(field != value) {
                field = value
                notifyChange(BR.region)
            }
        }

    fun onClickNext(view: View) {
        if(region == REGION_NO_SELECT) {
            showToast("지역을 선택해주세요")
        } else {
            val preference = view.context.getSharedPreferences(KEY_REGION, Context.MODE_PRIVATE)
            preference.edit().putString(KEY_REGION, region).apply()
            view.findNavController().navigate(R.id.contentFragment)
        }
    }

    fun onClickSelectAreaGangwon(view: View) {
        region = REGION_GANGWON
    }

    fun onClickSelectAreaChungnam(view: View) {
        region = REGION_CHUNGNAM
    }

    fun onClickSelectAreaChungbuk(view: View) {
        region = REGION_CHUNGBUK
    }

    fun onClickSelectAreaGyeongnam(view: View) {
        region = REGION_GYEONGNAM
    }

    fun onClickSelectAreaGyeongbuk(view: View) {
        region = REGION_GYEONGBUK
    }

    fun onClickSelectAreaJeonnam(view: View) {
        region = REGION_JEONNAM
    }

    fun onClickSelectAreaJeonbuk(view: View) {
        region = REGION_JEONBUK
    }

    fun onClickSelectAreaJeju(view: View) {
        region = REGION_JEJU
    }
}