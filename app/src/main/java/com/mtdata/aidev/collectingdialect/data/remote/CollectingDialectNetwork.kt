package com.mtdata.aidev.collectingdialect.data.remote

import com.mtdata.aidev.collectingdialect.BuildConfig
import com.mtdata.aidev.collectingdialect.data.model.CollectorInfo
import com.mtdata.aidev.collectingdialect.data.remote.request.RegisterSpeakerRequest
import com.mtdata.aidev.collectingdialect.data.remote.request.SignInRequest
import com.mtdata.aidev.collectingdialect.data.remote.request.SignUpRequest
import okhttp3.MultipartBody
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part

private interface CollectingDialectNetworkApi {
    @POST("api/collectors/signin")
    suspend fun signIn(@Body signInRequest: SignInRequest): NetworkResponse<CollectorInfo>

    @POST("api/collectors/signup")
    suspend fun signUp(@Body signUpRequest: SignUpRequest): NetworkResponse<String>

    @POST("api/speakers")
    suspend fun registerSpeaker(@Body registerSpeakerRequest: RegisterSpeakerRequest): NetworkResponse<String>

    @Multipart
    @POST("api/records")
    suspend fun sendRecordData(@Part part: List<MultipartBody.Part>): NetworkResponse<Boolean>
}

private data class NetworkResponse<T>(
    val data: T,
)

object CollectingDialectNetwork {
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
    private val networkApi = Retrofit.Builder()
        .baseUrl("http://localhost/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()
        .create(CollectingDialectNetworkApi::class.java)

    suspend fun signIn(collectorId: String, password: String): CollectorInfo =
        networkApi.signIn(SignInRequest(collectorId, password)).data

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
        password: String
    ): String = networkApi.signUp(
        SignUpRequest(
            gender,
            birthYear,
            residenceProvince,
            residenceCity,
            residencePeriod,
            job,
            academicBackground,
            healthCondition,
            collectingOrganization,
            password
        )
    ).data

    suspend fun registerSpeaker(
        gender: String,
        birthYear: Int,
        residenceProvince: String,
        residenceCity: Int,
        residencePeriod: Int,
        job: String?,
        academicBackground: Int?,
        healthCondition: Int?
    ): String = networkApi.registerSpeaker(
        RegisterSpeakerRequest(
            gender,
            birthYear,
            residenceProvince,
            residenceCity,
            residencePeriod,
            job,
            academicBackground,
            healthCondition
        )
    ).data

    suspend fun sendRecordData(records: List<MultipartBody.Part>): Boolean = networkApi.sendRecordData(records).data
}