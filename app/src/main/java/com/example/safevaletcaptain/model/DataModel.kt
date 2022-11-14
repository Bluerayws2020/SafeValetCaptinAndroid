package com.example.safevaletcaptain.model

import com.google.gson.annotations.SerializedName

sealed class NetworkResults<out R> {
    data class Success<out T>(val data: T) : NetworkResults<T>()
    data class Error(val exception: Exception) : NetworkResults<Nothing>()
}

data class LoginDriverModel(

    @SerializedName("msg") val status: MessageModel,
    @SerializedName("data") val driver: DriverModel,

    )

data class MessageModel(
    @SerializedName("status") val status: Int,
    @SerializedName("message") val msg: String
)


data class DriverModel(
    @SerializedName("uid") val uid: String,
    @SerializedName("type") val type: String,
    @SerializedName("name") val name: String,
    @SerializedName("phone") val phone: String,
    @SerializedName("station_responsible") val station_responsible: String,
    @SerializedName("company_id") val company_id: String,
    @SerializedName("driver_image") val driver_image: String,
    @SerializedName("driver_active") val driver_active: String,
    @SerializedName("manager") val manager: Int
    )