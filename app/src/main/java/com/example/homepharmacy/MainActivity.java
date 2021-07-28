package com.example.homepharmacy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.NavDirections;
import androidx.navigation.fragment.NavHostFragment;

import android.content.ClipData;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    private static NavController navController;
    private static NavHostFragment navHostFragment;
    private static BottomNavigationView mainBottomNavigator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_main_activity_host_fragment);
        navController = navHostFragment.getNavController();

        mainBottomNavigator = (BottomNavigationView) findViewById(R.id.main_activity_bottom_navigation);
        mainBottomNavigator.setItemIconTintList(null); //getting rid of background in mainBottomNavigator
        mainBottomNavigator.setOnNavigationItemSelectedListener(item -> { //setting up a listener for mainBottomNavigator
            switch (item.getItemId()) {
                case R.id.drugs_bottom_menu_item:
                    if (navController.getCurrentDestination().getId() != R.id.drugs_destination_fragment) {
                        navController.navigate(R.id.action_calendarFragment_to_drugsFragment); //changing navigation fragment
                        return true;
                    }
                    return false;
                case R.id.calendar_bottom_menu_item:
                    if (navController.getCurrentDestination().getId() != R.id.calendar_destination_fragment) {
                        navController.navigate(R.id.action_drugsFragment_to_calendarFragment);
                        return true;
                    }
                    return false;
                default:
                    return false;
            }
        });
    }
}