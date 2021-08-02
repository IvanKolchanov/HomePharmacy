package com.example.homepharmacy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.navigation.NavController;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.content.ClipData;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    private static AppBarConfiguration mainActivityToolbarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar mainActivityToolbar = findViewById(R.id.main_activity_toolbar);
        setSupportActionBar(mainActivityToolbar);

        BottomNavigationView mainBottomNavigator = findViewById(R.id.main_activity_bottom_navigation);
        mainBottomNavigator.setItemIconTintList(null);

        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_main_activity_host_fragment);
        NavController navController = Objects.requireNonNull(navHostFragment).getNavController();
        NavigationUI.setupWithNavController(mainBottomNavigator, navController);
        mainActivityToolbarConfiguration = new AppBarConfiguration.Builder(R.id.drugs_destination_fragment, R.id.calendar_destination_fragment).build();
        NavigationUI.setupActionBarWithNavController(this, navController, mainActivityToolbarConfiguration);

    }
}