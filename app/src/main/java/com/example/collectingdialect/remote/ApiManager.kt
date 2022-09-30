package com.example.collectingdialect.remote

import com.example.collectingdialect.BuildConfig
import okhttp3.Call
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.MultipartBody
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.asRequestBody
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File

object ApiManager {
    private val okHttpClient = OkHttpClient.Builder()
        .addInterceptor(HttpLoggingInterceptor()
            .setLevel(
                if(BuildConfig.DEBUG) {
                    HttpLoggingInterceptor.Level.BODY
                } else {
                    HttpLoggingInterceptor.Level.NONE
                }
            )
        )
        .build()
    private val retrofit = Retrofit.Builder()
        //.baseUrl("http://211.224.57.63:3000/")
        .baseUrl("http://223.130.160.210:3000/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()
    val apiService = retrofit.create(ApiInterface::class.java)

    fun createUploadRecordCall(params: Map<String, String>, fileList: List<File>): Call {
        //val headerString = "multipart/form-data; boundary=------2-18COLLECTINGDIALECTBOUNDARY; charset=UTF-8"
        val headerString = "multipart/form-data; charset=utf-8"
        val mediaType = headerString.toMediaType()
        val multipartBodyBuilder = MultipartBody.Builder()
            .setType(mediaType)
            //.setType(MultipartBody.FORM)
        params.forEach { entry ->
            multipartBodyBuilder.addFormDataPart(entry.key, entry.value)
        }
        fileList.forEach { file ->
            multipartBodyBuilder.addFormDataPart("recfile", file.name, file.asRequestBody())
        }
        val body = multipartBodyBuilder.build()
        val request = Request.Builder()
            .url("http://211.224.57.63:3000/api/records")
            //.addHeader("content-type", headerString)
            .post(body)
            .build()
        return okHttpClient.newCall(request)
    }
}