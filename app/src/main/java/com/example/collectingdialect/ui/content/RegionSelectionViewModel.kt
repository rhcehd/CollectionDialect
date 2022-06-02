package com.example.collectingdialect.ui.content

import android.view.View
import android.widget.ImageView
import androidx.databinding.Bindable
import androidx.databinding.BindingAdapter
import androidx.navigation.findNavController
import com.example.collectingdialect.BR
import com.example.collectingdialect.R
import com.example.collectingdialect.ui.BaseViewModel

class RegionSelectionViewModel: BaseViewModel() {
    companion object {
        @JvmStatic
        @BindingAdapter("region")
        fun selectRegion(view: ImageView, region: Int) {
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

        const val REGION_NO_SELECT = 0
        const val REGION_GANGWON = 1
        const val REGION_CHUNGNAM = 2
        const val REGION_CHUNGBUK = 3
        const val REGION_GYEONGNAM = 4
        const val REGION_GYEONGBUK = 5
        const val REGION_JEONNAM = 6
        const val REGION_JEONBUK = 7
        const val REGION_JEJU = 8
    }

    var region: Int = REGION_NO_SELECT
        @Bindable get
        set(value) {
            if(field != value) {
                field = value
                notifyChange(BR.region)
            }
        }

    fun onClickNext(view: View) {
        view.findNavController().navigate(R.id.contentFragment)
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