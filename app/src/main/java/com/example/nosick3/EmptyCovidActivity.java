package com.example.nosick3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.cuberto.liquid_swipe.LiquidPager;

public class EmptyCovidActivity extends AppCompatActivity {

    LiquidPager covidpager;
    CovidViewPager adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empty_covid);
        covidpager = findViewById(R.id.covidpager);
        adapter = new CovidViewPager(getSupportFragmentManager(), 1);

        covidpager.setAdapter(adapter);
    }
}