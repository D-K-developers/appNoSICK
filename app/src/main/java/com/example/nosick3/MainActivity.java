package com.example.nosick3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.widget.Toolbar;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle toggle;
    Toolbar toolbar;
    NavigationView navigationView;
    Button covidbtn;
    Button flubtn;
    Button ebolabtn;
    Button birdflubtn;
    Button menubar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawerLayout=findViewById(R.id.drawer);
        toolbar = findViewById(R.id.toolBar);
        menubar = findViewById(R.id.menu);
        covidbtn = (Button) findViewById(R.id.button);
        flubtn = (Button) findViewById(R.id.button2);
        ebolabtn = (Button) findViewById(R.id.button3);
        birdflubtn = (Button) findViewById(R.id.button4);
        setSupportActionBar(toolbar);
        covidbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, CovidActivity.class));
            }
        });

        flubtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, FluActivity.class));
            }
        });

        ebolabtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Ebola.class));
            }
        });

        birdflubtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, BirdFluActivity.class));
            }
        });


        toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int id = menuItem.getItemId();
                switch (id){
                    case R.id.coronavirus:
                        break;

                    case R.id.flue:
                        break;

                    case R.id.ebola:
                        break;

                    case R.id.bird_flu:
                        break;

                    case R.id.settings:
                        break;

                    case R.id.support:
                        break;

                    default:
                        return true;
                }
                if (id == R.id.coronavirus){
                    startActivity(new Intent(MainActivity.this, CovidActivity.class));
                }

                if (id == R.id.flue){
                    startActivity(new Intent(MainActivity.this, FluActivity.class));
                }

                if (id == R.id.ebola){
                    startActivity(new Intent(MainActivity.this, Ebola.class));
                }

                if (id == R.id.bird_flu){
                    startActivity(new Intent(MainActivity.this, BirdFluActivity.class));
                }

                if (id == R.id.settings){
                    startActivity(new Intent(MainActivity.this, SettingsActivity.class));
                }

                if (id == R.id.support){
                    startActivity(new Intent(MainActivity.this, SupportActivity.class));
                }

                return true;
            }
        });






        getSupportActionBar().hide();
    }
}