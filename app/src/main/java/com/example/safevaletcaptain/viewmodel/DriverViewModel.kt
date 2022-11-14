package com.example.safevaletcaptain.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.safevaletcaptain.helpers.HelperUtils
import com.example.safevaletcaptain.model.LoginDriverModel
import com.example.safevaletcaptain.model.NetworkResults
import com.example.safevaletcaptain.repo.NetworkRepository
import kotlinx.coroutines.launch

class DriverViewModel(application: Application): AndroidViewModel(application) {

    private val deviceId = HelperUtils.getAndroidID(application.applicationContext)
    private val repo = NetworkRepository

    private val loginDriverMessageLiveData = MutableLiveData<NetworkResults<LoginDriverModel>>()


    fun driverLogin(phone: String, deviceId: String){
        viewModelScope.launch{
            loginDriverMessageLiveData.value = repo.driverLogin(phone, deviceId)
        }
    }



    fun getLoginResponse() = loginDriverMessageLiveData

}