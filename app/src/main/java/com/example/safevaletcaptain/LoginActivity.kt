package com.example.safevaletcaptain

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.safevaletcaptain.databinding.ActivityLoginBinding
import com.example.safevaletcaptain.helpers.HelperUtils
import com.example.safevaletcaptain.helpers.ViewUtils.hide
import com.example.safevaletcaptain.helpers.ViewUtils.inVisible
import com.example.safevaletcaptain.helpers.ViewUtils.isInputEmpty
import com.example.safevaletcaptain.helpers.ViewUtils.show
import com.example.safevaletcaptain.model.DriverModel
import com.example.safevaletcaptain.model.NetworkResults
import com.example.safevaletcaptain.viewmodel.DriverViewModel
import retrofit2.HttpException

class LoginActivity : AppCompatActivity() {         //, View.OnClickListener {

    private lateinit var binding: ActivityLoginBinding
    private val driverVM by viewModels<DriverViewModel>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()


        driverVM.getLoginResponse().observe(this) { result ->
            when (result) {
                is NetworkResults.Success -> {
                    if (result.data.status.status == 1) {
                        saveUserData(
                            result.data.driver
                        )
                        val intentSignIn = Intent(this, HomeActivity::class.java)
                        startActivity(intentSignIn)
                        finishAffinity()
                    } else {

                    }
                }
                is NetworkResults.Error -> {
                    result.exception.printStackTrace()
                    hideProgress()
                    if (result.exception is HttpException)
                        showMessage(result.exception.message())
                    else
                        showMessage("No Internet connection")
                }
            }
        }

        binding.signInBtn.setOnClickListener {
            HelperUtils.hideKeyBoard(this)
            if (isInputValid()) {
                binding.progressBarLogin.show()
                it.inVisible()
                driverVM.driverLogin(
                    binding.driverPhone.text.toString(),
                    HelperUtils.getAndroidID(this)
                )
            }
        }


    }

    private fun isInputValid(): Boolean {
        var status = true

//        if (binding.userName.isInputEmpty()) {
//            status = false
//            binding.userName.error = "Required"
//        }

        if (binding.driverPhone.isInputEmpty()) {
            status = false
            binding.driverPhone.error = "Required" //getString(R.string.required)
        }

        return status
    }

    private fun saveUserData(driver: DriverModel) {
        val sharedPreferences = getSharedPreferences(HelperUtils.SHARED_PREF, MODE_PRIVATE)
        sharedPreferences.edit().apply {
            putString("uid", driver.uid.toString())
            putString("user_type", driver.name)

        }.apply()
    }


    private fun showMessage(message: String?) =
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()

    private fun hideProgress() {
        binding.signInBtn.show()
        binding.progressBarLogin.hide()
    }
}