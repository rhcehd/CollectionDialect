package com.mtdata.aidev.collectingdialect.data.remote

import com.mtdata.aidev.collectingdialect.data.model.CollectorInfo
import okhttp3.MultipartBody

interface CollectingDialectNetworkDataSource {
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
    suspend fun uploadRecord(records: List<MultipartBody.Part>): Boolean
}