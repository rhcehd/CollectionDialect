package com.mtdata.aidev.collectingdialect.data.repository.impl

import com.mtdata.aidev.collectingdialect.data.remote.CollectingDialectNetworkDataSource
import com.mtdata.aidev.collectingdialect.data.repository.RecordRepository
import okhttp3.MultipartBody

class RecordRepositoryImpl(
    private val collectingDialectNetworkDataSource: CollectingDialectNetworkDataSource
): RecordRepository {
    override suspend fun uploadRecord(records: List<MultipartBody.Part>): Boolean {
        return collectingDialectNetworkDataSource.uploadRecord(records)
    }
}