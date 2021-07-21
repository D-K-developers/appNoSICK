package com.example.nosick3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class SupportActivity extends AppCompatActivity {
    Button copy;
    Button copy2;
    TextView ct;
    TextView ct2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_support);
        CardView cardView = (CardView) findViewById(R.id.cardView7);
        CardView cardView1 = (CardView) findViewById(R.id.cardView8);
        CardView cardView2 = (CardView) findViewById(R.id.cardView6);
        CardView cardView3 = (CardView) findViewById(R.id.cardView5);
        cardView.setElevation(0);
        cardView1.setElevation(0);
        cardView2.setElevation(0);
        cardView3.setElevation(0);
        copy = findViewById(R.id.copy);
        copy2 = findViewById(R.id.copy2);
        ct = findViewById(R.id.copy_text);
        ct2 = findViewById(R.id.switch_o);
        copy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClipboardManager clipboardManager = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clipData = ClipData.newPlainText("", ct.getText().toString());
                clipboardManager.setPrimaryClip(clipData);

                Toast.makeText(SupportActivity.this, "Скопировано", Toast.LENGTH_SHORT).show();
            }
        });

        copy2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClipboardManager clipboardManager = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clipData = ClipData.newPlainText("", ct2.getText().toString());
                clipboardManager.setPrimaryClip(clipData);

                Toast.makeText(SupportActivity.this, "Скопировано", Toast.LENGTH_SHORT).show();
            }
        });
    }
}