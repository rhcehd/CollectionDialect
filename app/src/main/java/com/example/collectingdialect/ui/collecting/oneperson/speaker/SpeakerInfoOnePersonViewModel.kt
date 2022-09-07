package com.example.collectingdialect.ui.collecting.oneperson.speaker

import android.view.View
import android.widget.EditText
import androidx.databinding.Bindable
import androidx.navigation.NavOptions
import androidx.navigation.findNavController
import com.example.collectingdialect.BR
import com.example.collectingdialect.R
import com.example.collectingdialect.data.SpeakerInfo
import com.example.collectingdialect.remote.ApiManager
import com.example.collectingdialect.remote.request.RegisterSpeakerRequest
import com.example.collectingdialect.remote.response.RegisterSpeakerResponse
import com.example.collectingdialect.ui.MainActivity.Companion.showToast
import com.example.collectingdialect.ui.SharedViewModel
import com.example.collectingdialect.ui.collecting.InfoViewModel
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SpeakerInfoOnePersonViewModel: InfoViewModel() {
    var sharedViewModel: SharedViewModel? = null

    var gender: String = ""
        @Bindable get
        set(value) {
            if(field != value) {
                field = value
                genderError = null
                notifyChange(BR.gender)
                notifyChange(BR.genderList)
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

    private val birthYear: Int
        get() = try {
            birthYearString.toInt()
        } catch (e: NumberFormatException) {
            9999
        }
    var birthYearError: String? = null
        @Bindable get
        set(value) {
            if(field != value) {
                field = value
                notifyChange(BR.birthYearError)
            }
        }
    var birthYearString: String = ""
        @Bindable get
        set(value) {
            if(field != value) {
                field = value
                birthYearError = null
            }
        }

    var residenceProvince: String = ""
        @Bindable get
        set(value) {
            if(field != value) {
                field = value
                residenceProvinceError = null
                residenceCity = ""
                notifyChange(BR.residenceProvince)
                notifyChange(BR.residenceProvinceList)
                notifyChange(BR.residenceCityList)
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

    var residenceCity: String = ""
        @Bindable get
        set(value) {
            if(field != value) {
                field = value
                residenceCityError = null
                notifyChange(BR.residenceCity)
                notifyChange(BR.residenceCityList)
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
    val residenceCityList: Array<String>
        @Bindable get() = when(residenceProvince) {
            RESIDENCE_PROVINCE_GANGWON_STRING -> cityListGangwon
            RESIDENCE_PROVINCE_GYEONGSANG_STRING -> cityListGyeongsang
            RESIDENCE_PROVINCE_JEONRA_STRING -> cityListJeonra
            RESIDENCE_PROVINCE_CHUNGCHEONG_STRING -> cityListChungcheong
            RESIDENCE_PROVINCE_JEJU_STRING -> cityListJeju
            else -> emptyArray()
        }

    private val residencePeriod: Int
        get() = try {
            residencePeriodString.toInt()
        } catch (e: NumberFormatException) {
            0
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
        @Bindable get
        set(value) {
            if(field != value) {
                field = value
                residencePeriodError = null
            }
        }

    var job: String = ""
        @Bindable get
        set(value) {
            if(field != value) {
                field = value
                jobError = null
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
                academicBackgroundError = null
                notifyChange(BR.academicBackground)
                notifyChange(BR.academicBackgroundList)
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

    var healthCondition: String = ""
        @Bindable get
        set(value) {
            if(field != value) {
                field = value
                healthConditionError = null
                notifyChange(BR.healthCondition)
                notifyChange(BR.healthConditionList)
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

    private fun validateInput(): Boolean {
        genderError = if(gender.isEmpty()) {
            "필수입력"
        } else {
            null
        }
        birthYearError = if(birthYearString.isEmpty()) {
            "필수입력"
        } else {
            if(birthYearString.length != 4) {
                "4자리 숫자 입력"
            } else {
                null
            }
        }
        residenceProvinceError = if(residenceProvince.isEmpty()) {
            "필수입력"
        } else {
            null
        }
        residenceCityError = if(residenceCity.isEmpty()) {
            "필수입력"
        } else {
            null
        }
        residencePeriodError = if(residencePeriodString.isEmpty()) {
            "필수입력"
        } else {
            null
        }
        return genderError.isNullOrEmpty()
                && birthYearError.isNullOrEmpty()
                && residenceProvinceError.isNullOrEmpty()
                && residenceCityError.isNullOrEmpty()
                && residencePeriodError.isNullOrEmpty()
    }

    fun onClickLoadInfoButton(view: View) {
        val idInputEditText = EditText(view.context)
        MaterialAlertDialogBuilder(view.context)
            .setTitle("아이디를 입력해주세요")
            .setView(idInputEditText)
            .setPositiveButton("확인") { _, _ ->
                val speakerId = idInputEditText.text.toString()
                val speakerInfo = loadInfo(view.context, speakerId)
                if(speakerInfo != null) {
                    sharedViewModel?.currentSpeaker1Info = speakerInfo
                    view.findNavController().apply {
                        popBackStack()
                        navigate(R.id.setSelectionFragment)
                    }
                } else {
                    showToast("정보를 불러올 수 없습니다")
                }
            }
            .setNegativeButton("취소") { _, _ -> /*do nothing*/}
            .create()
            .show()
    }

    fun onClickButton(view: View) {
        val isValidInput = validateInput()
        if(!isValidInput) {
            return
        }
        val registerSpeakerRequest = RegisterSpeakerRequest(
            genderValueOf(gender),
            birthYear,
            residenceProvinceValueOf(residenceProvince),
            residenceCityValueOf(residenceCity),
            residencePeriod,
            job,
            academicBackgroundValueOf(academicBackground),
            healthConditionValueOf(healthCondition)
        )
        ApiManager.apiService.registerSpeaker(registerSpeakerRequest).enqueue(object:
            Callback<RegisterSpeakerResponse> {
            override fun onResponse(call: Call<RegisterSpeakerResponse>, response: Response<RegisterSpeakerResponse>) {
                if(response.isSuccessful) {

                    val speakerId = response.body()?.speakerId
                    if(speakerId != null) {
                        MaterialAlertDialogBuilder(view.context)
                            .setMessage("발화자 아이디는 $speakerId 입니다")
                            .setOnDismissListener {
                                val speakerInfo = SpeakerInfo(
                                    speakerId,
                                    gender,
                                    birthYear,
                                    residenceProvince,
                                    residenceCity,
                                    residencePeriod,
                                    job,
                                    academicBackground,
                                    healthCondition
                                )
                                sharedViewModel?.currentSpeaker1Info = speakerInfo
                                saveInfo(view.context, speakerInfo)
                                view.findNavController().apply {
                                    popBackStack()
                                    navigate(R.id.setSelectionFragment)
                                }
                            }
                            .setPositiveButton("확인") { _, _ -> /*do nothing*/ }
                            .create()
                            .show()
                    } else {

                    }
                } else {

                }
            }

            override fun onFailure(call: Call<RegisterSpeakerResponse>, t: Throwable) {
                t.printStackTrace()
            }
        })
    }
}