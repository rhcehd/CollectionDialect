package com.example.collectingdialect.data

import java.io.Serializable

data class SpeakerInfo(
    val speakerId: String,
    val gender: String,
    val birthYear: Int,
    val residenceProvince: String,
    val residenceCity: String,
    val residencePeriod: Int,
    val job: String,
    val academicBackground: String,
    val healthCondition: String
): Serializable
