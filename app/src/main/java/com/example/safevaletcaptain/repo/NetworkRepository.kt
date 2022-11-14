package com.example.safevaletcaptain.repo

import com.example.safevaletcaptain.api.ApiClient
import com.example.safevaletcaptain.model.LoginDriverModel
import com.example.safevaletcaptain.model.NetworkResults
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.withContext
import okhttp3.Dispatcher
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import retrofit2.http.Part

object NetworkRepository {

    suspend fun driverLogin(
    phone: String,
    device_player_id: String,
    ): NetworkResults<LoginDriverModel> {
        return withContext(Dispatchers.IO){
            val phoneBody = phone.toRequestBody("multipart/form-data".toMediaTypeOrNull())
            val devicePlayerIdBody = device_player_id.toRequestBody("multipart/form-data".toMediaTypeOrNull())

            try {
                val results = ApiClient.retrofitService.driverLogin(
                    phoneBody,
                    devicePlayerIdBody
                )
                NetworkResults.Success(results)
            } catch (e: java.lang.Exception){
                NetworkResults.Error(e)
            }
        }
    }

}