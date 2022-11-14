package com.example.safevaletcaptain

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.appcompat.app.AppCompatDelegate
import androidx.navigation.NavController
import com.example.safevaletcaptain.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() , View.OnClickListener {

    private lateinit var binding: ActivityMainBinding
    private var navController: NavController? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        supportActionBar?.hide()



        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }, 3000)


    }


    override fun onClick(v: View?) {
        TODO("Not yet implemented")
    }
}