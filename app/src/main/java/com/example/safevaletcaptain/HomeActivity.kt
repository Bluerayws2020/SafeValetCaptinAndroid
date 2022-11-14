package com.example.safevaletcaptain

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.view.GravityCompat
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.example.safevaletcaptain.databinding.ActivityHomeBinding
import com.google.android.material.navigation.NavigationView


class HomeActivity: AppCompatActivity(), View.OnClickListener , NavigationView.OnNavigationItemSelectedListener {

    private lateinit var binding: ActivityHomeBinding
    private var navController: NavController? = null
    private lateinit var appBarConfiguration: AppBarConfiguration


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)


        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController
        appBarConfiguration = AppBarConfiguration(navController!!.graph)

        NavigationUI.setupActionBarWithNavController(this, navController!!, appBarConfiguration)
        NavigationUI.setupWithNavController(binding.navigationView, navController!!)

        binding.navigationView.setNavigationItemSelectedListener(this)

    }

    override fun onClick(v: View?) {
        when (v?.id) {

        }
    }


    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        binding.drawerLayout.closeDrawer(GravityCompat.START)
        when (item.itemId) {

//
            R.id.history -> {
                navController?.navigate(R.id.historyFragment)
                return true
            }

            R.id.language -> {
                navController?.navigate(R.id.languageFragment)
                return true
            }
            else -> {
                return false
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(navController!!, appBarConfiguration)
    }

}