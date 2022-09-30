package com.mtdata.aidev.collectingdialect.remote

import com.mtdata.aidev.collectingdialect.remote.request.LoginRequest
import com.mtdata.aidev.collectingdialect.remote.request.RegisterCollectorRequest
import com.mtdata.aidev.collectingdialect.remote.request.RegisterSpeakerRequest
import com.mtdata.aidev.collectingdialect.remote.response.LoginResponse
import com.mtdata.aidev.collectingdialect.remote.response.RegisterCollectorResponse
import com.mtdata.aidev.collectingdialect.remote.response.RegisterSpeakerResponse
import okhttp3.MultipartBody
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