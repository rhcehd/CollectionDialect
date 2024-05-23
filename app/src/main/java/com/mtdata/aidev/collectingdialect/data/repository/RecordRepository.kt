package com.mtdata.aidev.collectingdialect.data.repository

import okhttp3.MultipartBody

interface RecordRepository {
    suspend fun uploadRecord(records: List<MultipartBody.Part>): Boolean
}