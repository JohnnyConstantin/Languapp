package com.example.languapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.languapp.Fragments.ChatFragment;
import com.example.languapp.Fragments.HomeFragment;
import com.example.languapp.Fragments.TasksFragment;
import com.example.languapp.Fragments.TestsFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Home extends MainActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        BottomNavigationView bN = findViewById(R.id.bottom_navigation);
        bN.setOnNavigationItemSelectedListener(navListener);


        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                new HomeFragment()).commit();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override

                /////// Обработка нажатия на иконку в навигейшн бар и создание фрагментов ///////

                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                    Fragment selectedFragment = null;

                    switch (menuItem.getItemId()){
                        case R.id.nav_home:
                            selectedFragment = new HomeFragment();
                            break;
                        case R.id.nav_tasks:
                            selectedFragment = new TasksFragment();
                            break;
                        case R.id.nav_tests:
                            selectedFragment = new TestsFragment();
                            break;
                        case R.id.nav_chat:
                            selectedFragment = new ChatFragment();
                            break;
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            selectedFragment).commit();

                    return true;
                }
            };

}
