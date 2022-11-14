package com.example.safevaletcaptain.api

import com.example.safevaletcaptain.model.LoginDriverModel
import okhttp3.RequestBody
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part

interface ApiServices {

    @Multipart
    @POST("Driverlogin/")
    suspend fun driverLogin(
        @Part("phone") phone: RequestBody,
        @Part("device_player_id") device_player_id: RequestBody,

    ): LoginDriverModel


}