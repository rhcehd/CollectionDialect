package com.example.collectingdialect.ui.collecting.twoperson.speaker

import android.view.View
import androidx.databinding.Bindable
import androidx.navigation.findNavController
import com.example.collectingdialect.BR
import com.example.collectingdialect.R
import com.example.collectingdialect.data.SpeakerInfo
import com.example.collectingdialect.remote.ApiManager
import com.example.collectingdialect.remote.request.RegisterSpeakerRequest
import com.example.collectingdialect.remote.response.RegisterSpeakerResponse
import com.example.collectingdialect.ui.SharedViewModel
import com.example.collectingdialect.ui.collecting.InfoViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SpeakerInfoTwoPersonViewModel: InfoViewModel() {
    var sharedViewModel: SharedViewModel? = null

    var gender1: String = ""
        @Bindable get
        set(value) {
            if(field != value) {
                field = value
                gender1Error = null
                notifyChange(BR.gender1)
                notifyChange(BR.genderList)
            }
        }
    var gender1Error: String? = null
        @Bindable get
        set(value) {
            if(field != value) {
                field = value
                notifyChange(BR.gender1Error)
            }
        }

    private val birthYear1: Int
        get() = try {
            birthYear1String.toInt()
        } catch (e: NumberFormatException) {
            9999
        }
    var birthYear1Error: String? = null
        @Bindable get
        set(value) {
            if(field != value) {
                field = value
                notifyChange(BR.birthYear1Error)
            }
        }
    var birthYear1String: String = ""
        @Bindable get
        set(value) {
            if(field != value) {
                field = value
                birthYear1Error = null
            }
        }

    var residenceProvince1: String = ""
        @Bindable get
        set(value) {
            if(field != value) {
                field = value
                residenceProvince1Error = null
                residenceCity1 = ""
                notifyChange(BR.residenceProvince1)
                notifyChange(BR.residenceProvinceList)
                notifyChange(BR.residenceCity1List)
            }
        }
    var residenceProvince1Error: String? = null
        @Bindable get
        set(value) {
            if(field != value) {
                field = value
                notifyChange(BR.residenceProvince1Error)
            }
        }

    var residenceCity1: String = ""
        @Bindable get
        set(value) {
            if(field != value) {
                field = value
                residenceCity1Error = null
                notifyChange(BR.residenceCity1)
                notifyChange(BR.residenceCity1List)
            }
        }
    var residenceCity1Error: String? = null
        @Bindable get
        set(value) {
            if(field != value) {
                field = value
                notifyChange(BR.residenceCity1Error)
            }
        }
    val residenceCity1List: Array<String>
        @Bindable get() = when(residenceProvince1) {
            RESIDENCE_PROVINCE_GANGWON_STRING -> cityListGangwon
            RESIDENCE_PROVINCE_GYEONGSANG_STRING -> cityListGyeongsang
            RESIDENCE_PROVINCE_JEONRA_STRING -> cityListJeonra
            RESIDENCE_PROVINCE_CHUNGCHEONG_STRING -> cityListChungcheong
            RESIDENCE_PROVINCE_JEJU_STRING -> cityListJeju
            else -> emptyArray()
        }

    private val residencePeriod1: Int
        get() = try {
            residencePeriod1String.toInt()
        } catch (e: NumberFormatException) {
            0
        }
    var residencePeriod1Error: String? = null
        @Bindable get
        set(value) {
            if(field != value) {
                field = value
                notifyChange(BR.residencePeriod1Error)
            }
        }
    var residencePeriod1String: String = ""
        @Bindable get
        set(value) {
            if(field != value) {
                field = value
                residencePeriod1Error = null
            }
        }

    var job1: String = ""
        @Bindable get
        set(value) {
            if(field != value) {
                field = value
                job1Error = null
            }
        }
    var job1Error: String? = null
        @Bindable get
        set(value) {
            if(field != value) {
                field = value
                notifyChange(BR.job1Error)
            }
        }

    var academicBackground1: String = ""
        @Bindable get
        set(value) {
            if(field != value) {
                field = value
                academicBackground1Error = null
                notifyChange(BR.academicBackground1)
                notifyChange(BR.academicBackgroundList)
            }
        }
    var academicBackground1Error: String? = null
        @Bindable get
        set(value) {
            if(field != value) {
                field = value
                notifyChange(BR.academicBackground1Error)
            }
        }

    var healthCondition1: String = ""
        @Bindable get
        set(value) {
            if(field != value) {
                field = value
                healthCondition1Error = null
                notifyChange(BR.healthCondition1)
                notifyChange(BR.healthConditionList)
            }
        }
    var healthCondition1Error: String? = null
        @Bindable get
        set(value) {
            if(field != value) {
                field = value
                notifyChange(BR.healthCondition1Error)
            }
        }


    var gender2: String = ""
        @Bindable get
        set(value) {
            if(field != value) {
                field = value
                gender2Error = null
                notifyChange(BR.gender2)
                notifyChange(BR.genderList)
            }
        }
    var gender2Error: String? = null
        @Bindable get
        set(value) {
            if(field != value) {
                field = value
                notifyChange(BR.gender2Error)
            }
        }

    private val birthYear2: Int
        get() = try {
            birthYear2String.toInt()
        } catch (e: NumberFormatException) {
            9999
        }
    var birthYear2Error: String? = null
        @Bindable get
        set(value) {
            if(field != value) {
                field = value
                notifyChange(BR.birthYear2Error)
            }
        }
    var birthYear2String: String = ""
        @Bindable get
        set(value) {
            if(field != value) {
                field = value
                birthYear2Error = null
            }
        }

    var residenceProvince2: String = ""
        @Bindable get
        set(value) {
            if(field != value) {
                field = value
                residenceProvince2Error = null
                residenceCity2 = ""
                notifyChange(BR.residenceProvince2)
                notifyChange(BR.residenceProvinceList)
                notifyChange(BR.residenceCity2List)
            }
        }
    var residenceProvince2Error: String? = null
        @Bindable get
        set(value) {
            if(field != value) {
                field = value
                notifyChange(BR.residenceProvince2Error)
            }
        }

    var residenceCity2: String = ""
        @Bindable get
        set(value) {
            if(field != value) {
                field = value
                residenceCity2Error = null
                notifyChange(BR.residenceCity2)
                notifyChange(BR.residenceCity2List)
            }
        }
    var residenceCity2Error: String? = null
        @Bindable get
        set(value) {
            if(field != value) {
                field = value
                notifyChange(BR.residenceCity2Error)
            }
        }
    val residenceCity2List: Array<String>
        @Bindable get() = when(residenceProvince2) {
            RESIDENCE_PROVINCE_GANGWON_STRING -> cityListGangwon
            RESIDENCE_PROVINCE_GYEONGSANG_STRING -> cityListGyeongsang
            RESIDENCE_PROVINCE_JEONRA_STRING -> cityListJeonra
            RESIDENCE_PROVINCE_CHUNGCHEONG_STRING -> cityListChungcheong
            RESIDENCE_PROVINCE_JEJU_STRING -> cityListJeju
            else -> emptyArray()
        }

    private val residencePeriod2: Int
        get() = try {
            residencePeriod2String.toInt()
        } catch (e: NumberFormatException) {
            0
        }
    var residencePeriod2Error: String? = null
        @Bindable get
        set(value) {
            if(field != value) {
                field = value
                notifyChange(BR.residencePeriod2Error)
            }
        }
    var residencePeriod2String: String = ""
        @Bindable get
        set(value) {
            if(field != value) {
                field = value
                residencePeriod1Error = null
            }
        }

    var job2: String = ""
        @Bindable get
        set(value) {
            if(field != value) {
                field = value
                job2Error = null
            }
        }
    var job2Error: String? = null
        @Bindable get
        set(value) {
            if(field != value) {
                field = value
                notifyChange(BR.job2Error)
            }
        }

    var academicBackground2: String = ""
        @Bindable get
        set(value) {
            if(field != value) {
                field = value
                academicBackground2Error = null
                notifyChange(BR.academicBackground2)
                notifyChange(BR.academicBackgroundList)
            }
        }
    var academicBackground2Error: String? = null
        @Bindable get
        set(value) {
            if(field != value) {
                field = value
                notifyChange(BR.academicBackground2Error)
            }
        }

    var healthCondition2: String = ""
        @Bindable get
        set(value) {
            if(field != value) {
                field = value
                healthCondition2Error = null
                notifyChange(BR.healthCondition2)
                notifyChange(BR.healthConditionList)
            }
        }
    var healthCondition2Error: String? = null
        @Bindable get
        set(value) {
            if(field != value) {
                field = value
                notifyChange(BR.healthCondition2Error)
            }
        }


    private fun validateInput(): Boolean {
        gender1Error = if(gender1.isEmpty()) {
            "필수입력"
        } else {
            null
        }
        birthYear1Error = if(birthYear1String.isEmpty()) {
            "필수입력"
        } else {
            if(birthYear1String.length != 4) {
                "4자리 숫자 입력"
            } else {
                null
            }
        }
        residenceProvince1Error = if(residenceProvince1.isEmpty()) {
            "필수입력"
        } else {
            null
        }
        residenceCity1Error = if(residenceCity1.isEmpty()) {
            "필수입력"
        } else {
            null
        }
        residencePeriod1Error = if(residencePeriod1String.isEmpty()) {
            "필수입력"
        } else {
            null
        }
        gender2Error = if(gender2.isEmpty()) {
            "필수입력"
        } else {
            null
        }
        birthYear2Error = if(birthYear2String.isEmpty()) {
            "필수입력"
        } else {
            if(birthYear2String.length != 4) {
                "4자리 숫자 입력"
            } else {
                null
            }
        }
        residenceProvince2Error = if(residenceProvince2.isEmpty()) {
            "필수입력"
        } else {
            null
        }
        residenceCity2Error = if(residenceCity2.isEmpty()) {
            "필수입력"
        } else {
            null
        }
        residencePeriod2Error = if(residencePeriod2String.isEmpty()) {
            "필수입력"
        } else {
            null
        }
        return gender1Error.isNullOrEmpty()
                && birthYear1Error.isNullOrEmpty()
                && residenceProvince1Error.isNullOrEmpty()
                && residenceCity1Error.isNullOrEmpty()
                && residencePeriod1Error.isNullOrEmpty()
                && gender2Error.isNullOrEmpty()
                && birthYear2Error.isNullOrEmpty()
                && residenceProvince2Error.isNullOrEmpty()
                && residenceCity2Error.isNullOrEmpty()
                && residencePeriod2Error.isNullOrEmpty()
    }

    fun onClickButton(view: View) {
        val isValidInput = validateInput()
        if(!isValidInput) {
            return
        }
        val registerSpeakerRequest1 = RegisterSpeakerRequest(
            genderValueOf(gender1),
            birthYear1,
            residenceProvinceValueOf(residenceProvince1),
            residenceCityValueOf(residenceCity1),
            residencePeriod1,
            job1,
            academicBackgroundValueOf(academicBackground1),
            healthConditionValueOf(healthCondition1),
        )
        val registerSpeakerRequest2 = RegisterSpeakerRequest(
            genderValueOf(gender2),
            birthYear2,
            residenceProvinceValueOf(residenceProvince2),
            residenceCityValueOf(residenceCity2),
            residencePeriod2,
            job2,
            academicBackgroundValueOf(academicBackground2),
            healthConditionValueOf(healthCondition2)
        )
        var requestCount = 0
        ApiManager.apiService.registerSpeaker(registerSpeakerRequest1).enqueue(object: Callback<RegisterSpeakerResponse>{
            override fun onResponse(
                call: Call<RegisterSpeakerResponse>,
                response: Response<RegisterSpeakerResponse>
            ) {
                if(response.isSuccessful) {
                    val speakerId1 = response.body()?.speakerId
                    if(speakerId1 != null) {
                        val speakerInfo1 = SpeakerInfo(
                            speakerId1,
                            gender1,
                            birthYear1,
                            residenceProvince1,
                            residenceCity1,
                            residencePeriod1,
                            job1,
                            academicBackground1,
                            healthCondition1
                        )
                        sharedViewModel?.currentSpeaker1Info = speakerInfo1
                        ApiManager.apiService.registerSpeaker(registerSpeakerRequest2).enqueue(object: Callback<RegisterSpeakerResponse>{
                            override fun onResponse(
                                call: Call<RegisterSpeakerResponse>,
                                response: Response<RegisterSpeakerResponse>
                            ) {
                                if(response.isSuccessful) {
                                    val speakerId2 = response.body()?.speakerId
                                    if(speakerId2 != null) {
                                        val speakerInfo2 = SpeakerInfo(
                                            speakerId2,
                                            gender1,
                                            birthYear1,
                                            residenceProvince1,
                                            residenceCity1,
                                            residencePeriod1,
                                            job1,
                                            academicBackground1,
                                            healthCondition1
                                        )
                                        sharedViewModel?.currentSpeaker2Info = speakerInfo2
                                        view.findNavController().apply {
                                            popBackStack()
                                            navigate(R.id.setSelectionFragment)
                                        }
                                    } else {

                                    }
                                } else {

                                }
                            }

                            override fun onFailure(call: Call<RegisterSpeakerResponse>, t: Throwable) {

                            }
                        })
                    } else {

                    }
                } else {

                }
            }

            override fun onFailure(call: Call<RegisterSpeakerResponse>, t: Throwable) {

            }
        })

    }
}