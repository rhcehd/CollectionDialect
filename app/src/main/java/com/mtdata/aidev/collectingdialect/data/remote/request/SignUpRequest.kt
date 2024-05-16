package com.mtdata.aidev.collectingdialect.data.remote.request

import com.google.gson.annotations.SerializedName

data class SignUpRequest(
    val gender: String,
    val birthYear: Int,
    val residenceProvince: String,
    val residenceCity: Int,
    val residencePeriod: Int,
    val job: String?,
    val academicBackground: Int?,
    val healthCondition: Int?,
    @SerializedName("collectionAgency") val collectingOrganization: String,
    val password: String
)
