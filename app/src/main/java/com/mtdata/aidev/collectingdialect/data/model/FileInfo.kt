package com.mtdata.aidev.collectingdialect.data.model

data class FileInfo(
    val fieldname: String,
    val originalname: String,
    val encoding: String,
    val mimetype: String,
    val destination: String,
    val filename: String,
    val path: String,
    val size: Int
)
