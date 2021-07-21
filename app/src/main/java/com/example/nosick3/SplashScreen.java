package com.example.nosick3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;



public class SplashScreen extends AppCompatActivity {
    ImageView bg;
    TextView text;
    LottieAnimationView lottieAnimationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        bg =  findViewById(R.id.backgr);
        text = findViewById(R.id.textsplash);
        lottieAnimationView = findViewById(R.id.splashanim);
        bg.animate().translationY(-3600).setDuration(1000).setStartDelay(2000);
        text.animate().translationY(3400).setDuration(1000).setStartDelay(2000);
        lottieAnimationView.animate().translationY(3400).setDuration(1000).setStartDelay(2000);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashScreen.this, MainActivity.class));
                finish();

            }
        }, 2700);








    }
}