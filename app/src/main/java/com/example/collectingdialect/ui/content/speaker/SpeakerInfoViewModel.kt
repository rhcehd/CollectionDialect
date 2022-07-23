package com.example.collectingdialect.ui.content.speaker

import android.os.Bundle
import android.view.View
import android.widget.NumberPicker
import androidx.core.os.bundleOf
import androidx.databinding.Bindable
import androidx.navigation.findNavController
import com.example.collectingdialect.BR
import com.example.collectingdialect.R
import com.example.collectingdialect.data.RecordManager
import com.example.collectingdialect.ui.BaseViewModel
import com.example.collectingdialect.ui.content.ContentViewModel
import com.example.collectingdialect.ui.content.region.RegionSelectionViewModel
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class SpeakerInfoViewModel: BaseViewModel() {
    var selectedContent: Int = 0

    var gender: String = ""
        @Bindable get
        set(value) {
            if(field != value) {
                field = value
            }
        }
    val genderArray: Array<String> = arrayOf("남성", "여성")

    var birthYear: Int = 0
        set(value) {
            field = value
            notifyChange(BR.birthYearString)
        }
    val birthYearString: String
        @Bindable get() = birthYear.toString()

    var residenceProvince: String = ""
        @Bindable get
        set(value) {
            if(field != value) {
                field = value
                notifyChange(BR.residenceProvince)
            }
        }
    val regionSelectResultListener: (String, Bundle) -> Unit = { requestKey, bundle ->
        if(requestKey == RegionSelectionViewModel.KEY_REGION) {
            residenceProvince = bundle.getString(RegionSelectionViewModel.KEY_REGION) ?: ""
        }
    }

    private var residencePeriod: Int = 0
        set(value) {
            if(field != value) {
                field = value
                notifyChange(BR.residencePeriodString)
            }
        }
    var residencePeriodString: String = ""
        @Bindable get() = residencePeriod.toString()
        set(value) {
            if(field != value) {
                field = value
                residencePeriod = try {
                    field.toInt()
                } catch (e: NumberFormatException) {
                    0
                }
            }
        }

    var job: String = ""
        @Bindable get
        set(value) {
            if(field != value) {
                field = value
                notifyChange(BR.job)
            }
        }

    var academicBackground: String = ""
        @Bindable get
        set(value) {
            if(field != value) {
                field = value
            }
        }
    val academicBackgroundList: Array<String> = arrayOf(
        "초졸이하",
        "중졸이하",
        "고졸이하",
        "대학원이하"
    )

    var healthCondition: String = ""
        @Bindable get
        set(value) {
            if(field != value) {
                field = value
            }
        }
    val healthConditionList: Array<String> = arrayOf(
        "치아손실",
        "조음장애",
        "치아손실/조음장애",
        "이상없음"
    )


    fun onClickBirthYearField(view: View) {
        val numberPicker = NumberPicker(view.context).apply {
            minValue = 1900
            maxValue = 2020
        }
        val dialog = MaterialAlertDialogBuilder(view.context)
            .setView(numberPicker)
            .setPositiveButton("확인") { _, _ -> }
            .setOnDismissListener {
                birthYear = numberPicker.value
            }
            .create()
        dialog.show()
    }

    fun onClickResidenceProvinceField(view: View) {
        view.findNavController().navigate(R.id.regionSelectionFragment)
    }

    fun onClickButton(view: View) {
        RecordManager.clearRecordDirectory()
        view.findNavController().navigate(R.id.setSelectionFragment, bundleOf(ContentViewModel.KEY_SELECTED_CONTENT to selectedContent))
    }
}