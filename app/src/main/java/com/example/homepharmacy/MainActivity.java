package com.example.homepharmacy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.NavDirections;
import androidx.navigation.fragment.NavHostFragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    private static NavController navController;
    private static NavHostFragment navHostFragment;
    private static BottomNavigationView mainButtomNavigator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_main_activity_host_fragment);
        navController = navHostFragment.getNavController();

        mainButtomNavigator = (BottomNavigationView) findViewById(R.id.main_activity_bottom_navigation);
        mainButtomNavigator.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.drugs_bottom_menu_item:
                    if (navController.getCurrentDestination().getId() != R.id.drugs_destination_fragment) {
                        navController.navigate(R.id.action_calendarFragment_to_drugsFragment);
                    }
                    break;
                case R.id.calendar_bottom_menu_item:
                    if (navController.getCurrentDestination().getId() != R.id.calendar_destination_fragment) {
                        navController.navigate(R.id.action_drugsFragment_to_calendarFragment);
                    }
                    break;
            }
            return true;
        });
    }
}