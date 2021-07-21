package com.example.nosick3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.L;

public class Ebola extends AppCompatActivity {
    Button back;
    TextView detected;
    TextView died;
    private ProgressBar detectedbar;
    private ProgressBar diedbar;
    Button readebola;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ebola);
        back = findViewById(R.id.back);


        detected = findViewById(R.id.detectedcount);
        detected.setText("28 637 / 7 830 458 560 людей");
        died = findViewById(R.id.deadcount);
        died.setText("11 315 / 28 637 людей");
        detectedbar = findViewById(R.id.ebolastat1);
        diedbar = findViewById(R.id.ebolastat2);
        diedbar.setMax(100);
        diedbar.setProgress(39);
        detectedbar.setMax(100);
        detectedbar.setProgress(4);
        readebola = findViewById(R.id.readebola);
        readebola.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Ebola.this, EmptyEbolaActivity.class));
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Ebola.this, MainActivity.class));
                finish();
            }
        });
    }
}