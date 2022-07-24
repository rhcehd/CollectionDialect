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
import com.example.collectingdialect.data.SpeakerInfo
import com.example.collectingdialect.ui.BaseViewModel
import com.example.collectingdialect.ui.SharedViewModel
import com.example.collectingdialect.ui.content.ContentViewModel
import com.example.collectingdialect.ui.content.region.RegionSelectionViewModel
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class SpeakerInfoViewModel: BaseViewModel() {
    var sharedViewModel: SharedViewModel? = null
    var selectedContent: Int = 0

    var gender: String = ""
        @Bindable get
        set(value) {
            if(field != value) {
                field = value
            }
        }
    var genderError: String? = null
        @Bindable get
        set(value) {
            if(field != value) {
                field = value
                notifyChange(BR.genderError)
            }
        }
    val genderArray: Array<String> = arrayOf("남성", "여성")

    var birthYear: Int = 0
        set(value) {
            field = value
            notifyChange(BR.birthYearString)
        }
    var birthYearError: String? = null
        @Bindable get
        set(value) {
            if(field != value) {
                field = value
                notifyChange(BR.birthYearError)
            }
        }
    val birthYearString: String
        @Bindable get() = birthYear.toString()

    var residenceProvince: String = ""
        @Bindable get
        set(value) {
            if(field != value) {
                field = value
                notifyChange(BR.residenceProvince)
                residenceProvinceError = null
            }
        }
    var residenceProvinceError: String? = null
        @Bindable get
        set(value) {
            if(field != value) {
                field = value
                notifyChange(BR.residenceProvinceError)
            }
        }
    val regionSelectResultListener: (String, Bundle) -> Unit = { requestKey, bundle ->
        if(requestKey == RegionSelectionViewModel.KEY_REGION) {
            residenceProvince = bundle.getString(RegionSelectionViewModel.KEY_REGION) ?: ""
        }
    }

    var residenceCity: String = ""
        @Bindable get
        set(value) {
            if(field != value) {
                field = value
                notifyChange(BR.residenceCity)
            }
        }
    var residenceCityError: String? = null
        @Bindable get
        set(value) {
            if(field != value) {
                field = value
                notifyChange(BR.residenceCityError)
            }
        }

    private var residencePeriod: Int = 0
        set(value) {
            if(field != value) {
                field = value
                notifyChange(BR.residencePeriodString)
            }
        }
    var residencePeriodError: String? = null
        @Bindable get
        set(value) {
            if(field != value) {
                field = value
                notifyChange(BR.residencePeriodError)
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
    var jobError: String? = null
        @Bindable get
        set(value) {
            if(field != value) {
                field = value
                notifyChange(BR.jobError)
            }
        }

    var academicBackground: String = ""
        @Bindable get
        set(value) {
            if(field != value) {
                field = value
            }
        }
    var academicBackgroundError: String? = null
        @Bindable get
        set(value) {
            if(field != value) {
                field = value
                notifyChange(BR.academicBackgroundError)
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
    var healthConditionError: String? = null
        @Bindable get
        set(value) {
            if(field != value) {
                field = value
                notifyChange(BR.healthConditionError)
            }
        }
    val healthConditionList: Array<String> = arrayOf(
        "치아손실",
        "조음장애",
        "치아손실/조음장애",
        "이상없음"
    )

    private fun validateInput(): Boolean {
        residenceProvinceError = if(residenceProvince.isNullOrEmpty()) {
            "필수입력"
        } else {
            null
        }
        return residenceProvinceError.isNullOrEmpty()
    }


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
        val isValidInput = validateInput()
        if(!isValidInput) {
            return
        }
        sharedViewModel?.currentSpeakerInfo = SpeakerInfo(
            gender,
            birthYear,
            residenceProvince,
            residenceCity,
            residencePeriod,
            job,
            academicBackground,
            healthCondition
        )
        view.findNavController().navigate(R.id.setSelectionFragment, bundleOf(ContentViewModel.KEY_SELECTED_CONTENT to selectedContent))
    }
}