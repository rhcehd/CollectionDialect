package com.mtdata.aidev.collectingdialect.data.remote

import com.mtdata.aidev.collectingdialect.data.model.CollectorInfo
import okhttp3.MultipartBody

private const val FAKE_COLLECTOR_ID = "1234"
private const val FAKE_SPEAKER_ID = "5678"
private const val FAKE_COLLECTOR_BIRTH_YEAR = 9999
class FakeCollectingDialectNetwork: CollectingDialectNetworkDataSource {
    override suspend fun signIn(collectorId: String, password: String): CollectorInfo {
        return CollectorInfo(FAKE_COLLECTOR_ID, FAKE_COLLECTOR_BIRTH_YEAR)
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
        return FAKE_COLLECTOR_ID
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
        return FAKE_SPEAKER_ID
    }

    override suspend fun uploadRecord(records: List<MultipartBody.Part>): Boolean {
        return records.isNotEmpty()
    }
}