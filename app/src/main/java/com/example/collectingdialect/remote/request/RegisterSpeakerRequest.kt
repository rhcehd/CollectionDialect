package com.example.collectingdialect.remote.request

import com.google.gson.annotations.SerializedName

data class RegisterSpeakerRequest(
    val gender: String,
    val birthYear: Int,
    val residenceProvince: String,
    val residenceCity: Int,
    val residencePeriod: Int,
    val job: String?,
    val academicBackground: Int?,
    val healthCondition: Int?
)
