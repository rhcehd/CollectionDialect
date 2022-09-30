package com.example.collectingdialect.ui.registration

import android.view.View
import androidx.databinding.Bindable
import androidx.navigation.findNavController
import com.example.collectingdialect.BR
import com.example.collectingdialect.remote.ApiManager
import com.example.collectingdialect.remote.request.RegisterCollectorRequest
import com.example.collectingdialect.remote.response.RegisterCollectorResponse
import com.example.collectingdialect.ui.MainActivity.Companion.showToast
import com.example.collectingdialect.ui.SharedViewModel
import com.example.collectingdialect.ui.collecting.InfoViewModel
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegistrationViewModel: InfoViewModel() {
    companion object {
        const val COLLECTING_ORGANIZATION_MTDATA_STRING = "엠티데이타"
        const val COLLECTING_ORGANIZATION_OLLIMCOMMUNICATIONS_STRING = "올림커뮤니케이션즈"
        const val COLLECTING_ORGANIZATION_CONSUMERINSIGHT_STRING = "컨슈머인사이트"
        const val COLLECTING_ORGANIZATION_HYEOKSINMIRAE_STRING = "혁신과미래"

        const val COLLECTING_ORGANIZATION_UNKNOWN = "un"
        const val COLLECTING_ORGANIZATION_MTDATA = "mt"
        const val COLLECTING_ORGANIZATION_OLLIMCOMMUNICATIONS = "ol"
        const val COLLECTING_ORGANIZATION_CONSUMERINSIGHT = "cs"
        const val COLLECTING_ORGANIZATION_HYEOKSINMIRAE = "hm"
    }

    var sharedViewModel: SharedViewModel? = null

    var gender: String = ""
        @Bindable get
        set(value) {
            if(field != value) {
                field = value
                genderError = null
                notifyChange(BR.gender)
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

    var collectingOrganization: String = ""
        @Bindable get
        set(value) {
            if(field != value) {
                field = value
                collectingOrganizationError = null
                notifyChange(BR.collectingOrganization)
            }
        }
    var collectingOrganizationError: String? = null
        @Bindable get
        set(value) {
            if(field != value) {
                field = value
                notifyChange(BR.collectingOrganizationError)
            }
        }
    val collectingOrganizationList: Array<String> = arrayOf(
        COLLECTING_ORGANIZATION_MTDATA_STRING,
        COLLECTING_ORGANIZATION_OLLIMCOMMUNICATIONS_STRING,
        COLLECTING_ORGANIZATION_CONSUMERINSIGHT_STRING,
        COLLECTING_ORGANIZATION_HYEOKSINMIRAE_STRING
    )

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
        /*jobError = if(job.isEmpty()) {
            "필수입력"
        } else {
            null
        }
        academicBackgroundError = if(academicBackground.isEmpty()) {
            "필수입력"
        } else {
            null
        }
        healthConditionError = if(healthCondition.isEmpty()) {
            "필수입력"
        } else {
            null
        }*/
        collectingOrganizationError = if(collectingOrganization.isEmpty()) "필수입력" else null
        return genderError.isNullOrEmpty()
                && birthYearError.isNullOrEmpty()
                && residenceProvinceError.isNullOrEmpty()
                && residenceCityError.isNullOrEmpty()
                && residencePeriodError.isNullOrEmpty()
                /*&& jobError.isNullOrEmpty()
                && academicBackgroundError.isNullOrEmpty()
                && healthConditionError.isNullOrEmpty()*/
                && collectingOrganizationError.isNullOrEmpty()
    }

    private fun collectingOrganizationValueOf(collectingOrganization: String): String {
        return when(collectingOrganization) {
            COLLECTING_ORGANIZATION_MTDATA_STRING -> COLLECTING_ORGANIZATION_MTDATA
            COLLECTING_ORGANIZATION_OLLIMCOMMUNICATIONS_STRING -> COLLECTING_ORGANIZATION_OLLIMCOMMUNICATIONS
            COLLECTING_ORGANIZATION_CONSUMERINSIGHT_STRING -> COLLECTING_ORGANIZATION_CONSUMERINSIGHT
            COLLECTING_ORGANIZATION_HYEOKSINMIRAE_STRING -> COLLECTING_ORGANIZATION_HYEOKSINMIRAE
            else -> COLLECTING_ORGANIZATION_UNKNOWN
        }
    }

    fun onClickRegistrationButton(view: View) {
        val isValidInput = validateInput()
        if(!isValidInput) {
            return
        }
        val gender = genderValueOf(gender)
        val residenceProvince = residenceProvinceValueOf(residenceProvince)
        val residenceCity = residenceCityValueOf(residenceCity)
        val academicBackground = academicBackgroundValueOf(academicBackground)
        val healthCondition = healthConditionValueOf(healthCondition)
        val collectingOrganization = collectingOrganizationValueOf(collectingOrganization)
        val registerCollectorRequest = RegisterCollectorRequest(
            gender,
            birthYear,
            residenceProvince,
            residenceCity,
            residencePeriod,
            job,
            academicBackground,
            healthCondition,
            collectingOrganization,
            ""
        )
        val navController = view.findNavController()
        ApiManager.apiService.registerCollector(registerCollectorRequest).enqueue(object: Callback<RegisterCollectorResponse>{
            override fun onResponse(
                call: Call<RegisterCollectorResponse>,
                response: Response<RegisterCollectorResponse>
            ) {
                if(response.isSuccessful) {
                    val collectorId = response.body()?.collectorId
                    if(collectorId != null) {
                        MaterialAlertDialogBuilder(view.context)
                            .setMessage("등록된 아이디/패스워드는 다음과 같습니다\n\n아이디 : $collectorId\n패스워드 : $collectorId")
                            .setOnDismissListener {
                                navController.navigateUp()
                            }
                            .setPositiveButton("확인") { _, _ -> /*do nothing*/ }
                            .create()
                            .show()
                    } else {
                        showToast("수집자 등록 실패")
                    }
                } else {
                    showToast("수집자 등록 실패")
                }
            }

            override fun onFailure(call: Call<RegisterCollectorResponse>, t: Throwable) {
                showToast("수집자 등록 실패")
            }
        })
    }

    fun onClickCancelButton(view: View) {
        view.findNavController().popBackStack()
    }
}