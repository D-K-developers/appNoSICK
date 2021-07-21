package com.example.nosick3;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.graphics.Paint;
import android.media.MediaParser;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.cuberto.liquid_swipe.LiquidPager;
import com.google.android.material.navigation.NavigationView;

import javax.security.auth.callback.Callback;

public class FluActivity extends AppCompatActivity {
    private int CurrentProgress = 37;
    private int CurrentProgress1 = 85;
    private ProgressBar progressBar;
    private ProgressBar progressBar1;
    private TextView percent;
    private TextView percent1;
    private Button read;
    LiquidPager pager;
    ViewPagerAdapter adapter;
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle toggle;
    Toolbar toolbar;
    NavigationView navigationView;
    Button back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flu);


        read = (Button) findViewById(R.id.btn_read);
        back = findViewById(R.id.back);

        read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FluActivity.this, LiqwidActivity.class));
            }
        });
        progressBar = findViewById(R.id.progressBar);
        progressBar1 = findViewById(R.id.progressBar1);
        progressBar.setProgress(CurrentProgress);
        progressBar1.setProgress(CurrentProgress1);
        progressBar.setMax(100);
        progressBar1.setMax(100);
        percent = findViewById(R.id.textView22);
        percent1 =findViewById(R.id.textView24);
        String a = Integer.toString(CurrentProgress);
        percent.setText("37 %");
        percent1.setText("85 %");
        CardView cardView = (CardView) findViewById(R.id.cardView11);
        cardView.setCardElevation(0);
        CardView cardView8 = (CardView) findViewById(R.id.cardView8);
        cardView8.setCardElevation(0);
        CardView cardView12 = (CardView) findViewById(R.id.cardView12);
        cardView12.setCardElevation(0);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FluActivity.this, MainActivity.class));
                finish();
            }
        });


    }
}