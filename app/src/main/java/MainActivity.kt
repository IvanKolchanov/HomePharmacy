package com.example.homepharmacy

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_main_activity_host_fragment) as NavHostFragment?
        val navController = navHostFragment!!.navController //getting navController for navigation in the app

        val mainBottomNavigator = findViewById<BottomNavigationView>(R.id.main_activity_bottom_navigation)
        mainBottomNavigator.itemIconTintList = null //setting icon color to null, because otherwise they would whole
        NavigationUI.setupWithNavController(mainBottomNavigator, navController) //connecting bottomNavigationView to navController for it's auto update
    }
}