package com.example.collectingdialect.remote

import com.example.collectingdialect.remote.request.LoginRequest
import com.example.collectingdialect.remote.request.RegistrationRequest
import com.example.collectingdialect.remote.response.SendRecordDataResponse
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.*

interface ApiInterface {
    @POST("/api/users/signin")
    fun login(@Body loginRequest: LoginRequest): Call<Unit>

    @POST("/api/users/signup")
    fun registration(@Body registrationRequest: RegistrationRequest): Call<Unit>

    @Multipart
    @POST("/api/records")
    fun sendRecordData(@Part file: List<MultipartBody.Part>): Call<SendRecordDataResponse>
}