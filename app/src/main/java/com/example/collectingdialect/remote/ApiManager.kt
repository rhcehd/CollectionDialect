package com.example.collectingdialect.remote

import android.content.Context
import android.media.MediaMetadataRetriever
import com.example.collectingdialect.remote.request.LoginRequest
import com.example.collectingdialect.remote.request.RegistrationRequest
import com.example.collectingdialect.remote.response.SendRecordDataResponse
import com.example.collectingdialect.ui.MainActivity
import com.example.collectingdialect.ui.login.LoginViewModel
import okhttp3.*
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody.Companion.asRequestBody
import okhttp3.internal.EMPTY_REQUEST
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiManager {
    private val okHttpClient = OkHttpClient.Builder()
        .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
        .build()
    private val retrofit = Retrofit.Builder()
        .baseUrl("http://211.224.57.63:3000")
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()
    private val apiService = retrofit.create(ApiInterface::class.java)

    fun login(id: String, password: String, onSuccess: () -> Unit, onFailure: (Int) -> Unit) {
        val loginRequest = LoginRequest(id, password)
        apiService.login(loginRequest).enqueue(object: Callback<Unit>{
            override fun onResponse(call: Call<Unit>, response: Response<Unit>) {
                if(response.isSuccessful) {
                    onSuccess.invoke()
                } else {
                    onFailure.invoke(response.code())
                }
            }

            override fun onFailure(call: Call<Unit>, t: Throwable) {
                onFailure.invoke(0)
            }
        })
    }

    fun registration(id: String, password: String, onSuccess: () -> Unit, onFailure: () -> Unit) {
        val registrationRequest = RegistrationRequest(id, password)
        apiService.registration(registrationRequest).enqueue(object: Callback<Unit>{
            override fun onResponse(call: Call<Unit>, response: Response<Unit>) {
                if(response.isSuccessful) {
                    onSuccess.invoke()
                } else {
                    onFailure.invoke()
                }
            }

            override fun onFailure(call: Call<Unit>, t: Throwable) {
                onFailure.invoke()
            }
        })
    }

    fun sendRecordData(context: Context, onSuccess: () -> Unit, onFailure: () -> Unit) {
        //val context = MainActivity.contextRequester?.invoke() ?: return
        val currentUserName = context.getSharedPreferences(LoginViewModel.PREFERENCE_USER, Context.MODE_PRIVATE).getString(LoginViewModel.KEY_ID, "") ?: ""
        val mediaDirectory = context.filesDir
        //val recordList = mediaDirectory?.listFiles() ?: emptyArray()
        val recordList = mediaDirectory?.listFiles{ file ->
            file.name.startsWith(currentUserName)
        } ?: emptyArray()
        val multipartRecord = arrayListOf<MultipartBody.Part>()
        recordList.forEach { file ->
            val requestBody = file.asRequestBody("multipart/form-data".toMediaType())
            multipartRecord.add(MultipartBody.Part.createFormData("recfile", file.name, requestBody))
        }
        apiService.sendRecordData(multipartRecord).enqueue(object: Callback<SendRecordDataResponse>{
            override fun onResponse(
                call: Call<SendRecordDataResponse>,
                response: Response<SendRecordDataResponse>
            ) {
                if(response.isSuccessful) {
                    val data = response.body()?.fileInfo
                    if(data != null) {
                        onSuccess.invoke()
                    }else  {
                        onFailure.invoke()
                    }
                } else {
                    onFailure.invoke()
                }
            }

            override fun onFailure(call: Call<SendRecordDataResponse>, t: Throwable) {
                onFailure.invoke()
            }
        })
    }
}