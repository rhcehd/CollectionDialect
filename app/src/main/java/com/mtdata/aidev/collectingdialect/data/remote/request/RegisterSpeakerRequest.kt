package com.mtdata.aidev.collectingdialect.data.remote.request

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
