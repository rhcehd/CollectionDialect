package com.mtdata.aidev.collectingdialect.data.repository

import com.mtdata.aidev.collectingdialect.data.model.CollectorInfo

interface UserRepository {
    suspend fun signIn(collectorId: String, password: String): CollectorInfo
    suspend fun signUp(
        gender: String,
        birthYear: Int,
        residenceProvince: String,
        residenceCity: Int,
        residencePeriod: Int,
        job: String?,
        academicBackground: Int?,
        healthCondition: Int?,
        collectingOrganization: String,
    ): String
    suspend fun registerSpeaker(
        gender: String,
        birthYear: Int,
        residenceProvince: String,
        residenceCity: Int,
        residencePeriod: Int,
        job: String?,
        academicBackground: Int?,
        healthCondition: Int?
    ): String
}