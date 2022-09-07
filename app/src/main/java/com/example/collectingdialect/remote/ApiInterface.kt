package com.example.collectingdialect.remote

import com.example.collectingdialect.data.CollectorInfo
import com.example.collectingdialect.remote.request.LoginRequest
import com.example.collectingdialect.remote.request.RegisterCollectorRequest
import com.example.collectingdialect.remote.request.RegisterSpeakerRequest
import com.example.collectingdialect.remote.response.LoginResponse
import com.example.collectingdialect.remote.response.RegisterCollectorResponse
import com.example.collectingdialect.remote.response.RegisterSpeakerResponse
import com.example.collectingdialect.remote.response.SendRecordDataResponse
import okhttp3.MultipartBody
import okhttp3.Request
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.*

interface ApiInterface {
    @POST("api/collectors/signin")
    fun login(@Body loginRequest: LoginRequest): Call<LoginResponse>

    @POST("api/collectors/signup")
    fun registerCollector(@Body registerCollectorRequest: RegisterCollectorRequest): Call<RegisterCollectorResponse>

    @POST("api/speakers")
    fun registerSpeaker(@Body registerSpeakerRequest: RegisterSpeakerRequest): Call<RegisterSpeakerResponse>

    @Multipart
    @POST("api/records")
    fun sendRecordData(@Part part: List<MultipartBody.Part>): Call<Unit>
}