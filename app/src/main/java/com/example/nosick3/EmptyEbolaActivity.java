package com.example.nosick3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

import com.cuberto.liquid_swipe.LiquidPager;

public class EmptyEbolaActivity extends AppCompatActivity {

    LiquidPager pager;
    LiquidEbolaAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empty_ebola);
        pager = findViewById(R.id.ebolapager);

        adapter = new LiquidEbolaAdapter(getSupportFragmentManager(), 1);

        pager.setAdapter(adapter);

    }
}