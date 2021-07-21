package com.example.nosick3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.cuberto.liquid_swipe.LiquidPager;

public class LiqwidActivity extends AppCompatActivity {
    LiquidPager pager;
    ViewPagerAdapter adapter;
    Button main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liqwid);
        main = findViewById(R.id.onmain);
        pager = findViewById(R.id.pager);
        adapter = new ViewPagerAdapter(getSupportFragmentManager(), 1);

        pager.setAdapter(adapter);


    }


}