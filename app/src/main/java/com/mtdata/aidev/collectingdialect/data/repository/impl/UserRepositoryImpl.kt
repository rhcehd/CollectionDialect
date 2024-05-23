package com.mtdata.aidev.collectingdialect.data.repository.impl

import com.mtdata.aidev.collectingdialect.data.model.CollectorInfo
import com.mtdata.aidev.collectingdialect.data.remote.CollectingDialectNetworkDataSource
import com.mtdata.aidev.collectingdialect.data.repository.UserRepository

class UserRepositoryImpl(
    private val collectingDialectNetworkDataSource: CollectingDialectNetworkDataSource
): UserRepository {
    override suspend fun signIn(collectorId: String, password: String): CollectorInfo {
        return collectingDialectNetworkDataSource.signIn(collectorId, password)
    }

    override suspend fun signUp(
        gender: String,
        birthYear: Int,
        residenceProvince: String,
        residenceCity: Int,
        residencePeriod: Int,
        job: String?,
        academicBackground: Int?,
        healthCondition: Int?,
        collectingOrganization: String
    ): String {
        return collectingDialectNetworkDataSource.signUp(
            gender,
            birthYear,
            residenceProvince,
            residenceCity,
            residencePeriod,
            job,
            academicBackground,
            healthCondition,
            collectingOrganization
        )
    }

    override suspend fun registerSpeaker(
        gender: String,
        birthYear: Int,
        residenceProvince: String,
        residenceCity: Int,
        residencePeriod: Int,
        job: String?,
        academicBackground: Int?,
        healthCondition: Int?
    ): String {
        return collectingDialectNetworkDataSource.registerSpeaker(
            gender,
            birthYear,
            residenceProvince,
            residenceCity,
            residencePeriod,
            job,
            academicBackground,
            healthCondition
        )
    }
}