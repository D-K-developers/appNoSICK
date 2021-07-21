package com.example.nosick3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import io.paperdb.Paper;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import static android.telephony.AvailableNetworkInfo.PRIORITY_HIGH;
import static android.telephony.AvailableNetworkInfo.PRIORITY_LOW;

public class CovidActivity extends AppCompatActivity {

    private TextView rec;
    private TextView conf;
    private TextView dead;
    ImageView menu;
    Spinner spinner;
    Button open;
    Button push;
    private NotificationManager notificationManager;
    private static final int NOTIFY_ID = 1;
    private static final String CHANNEL_ID = "CHANNEL_ID";

    private String[] countries = {"Russia", "Afghanistan", "Albania", "Algeria", "Andorra", "Angola", "Antigua and Barbuda", "Argentina", "Armenia", "Australia", "Austria", "Azerbaijan", "Bangladesh", "Barbados", "Bahamas", "Bahrain", "Belarus", "Belgium", "Belize", "Benin", "Bhutan", "Bolivia", "Bosnia and Herzegovina", "Botswana", "Brazil", "British Virgin Islands", "Bulgaria", "Burkina Faso", "Burma", "Burundi", "Cambodia", "Cameroon", "Canada", "Central African Republic", "Chad", "Chile", "China", "Colombia", "Comoros", "Costa Rica", "Croatia", "Cyprus", "Czech Republic", "Denmark", "Dominica", "Dominican Republic", "Ecuador", "El Salvador", "Egypt", "Equatorial Guinea", "Eritrea", "Estonia", "Ethiopia", "Fiji", "Finland", "France", "Gabon", "Gambia", "Georgia", "Germany", "Ghana", "Greece", "Grenada", "Guatemala", "Guinea", "Guinea-Bissau", "Guyana", "Haiti", "Honduras", "Hungary", "Iceland", "India", "Indonesia", "Iraq", "Ireland", "Israel", "Italy", "Jamaica", "Japan", "Jordan", "Kazakhstan", "Kenya", "Kiribati", "Kuwait", "Kyrgyzstan", "Laos", "Latvia", "Lebanon", "Lesotho", "Liberia", "Libya", "Liechtenstein", "Lithuania", "Luxembourg", "Madagascar", "Malawi", "Malaysia", "Maldives", "Mali", "Malta", "Marshall Islands", "Mauritania", "Mauritius", "Mexico", "Moldova", "Monaco", "Mongolia", "Montenegro", "Morocco", "Mozambique", "Namibia", "Nepal", "Netherlands", "New Zealand", "Nicaragua", "Niger", "Nigeria", "Norway", "Oman", "Pakistan", "Palau", "Panama", "Papua New Guinea", "Paraguay", "Peru", "Philippines", "Poland", "Portugal", "Qatar", "Romania", "Rwanda", "Saint Kitts and Nevis", "Saint Lucia", "Samoa", "San Marino", "Saudi Arabia", "Senegal", "Serbia", "Seychelles", "Sierra Leone", "Singapore", "Slovakia", "Slovenia", "Solomon Islands", "Somalia", "South Africa", "Spain", "Sri Lanka", "Sudan", "Suriname", "Sweden", "Switzerland", "Syria", "Tajikistan", "Tanzania", "Thailand", "Togo", "Trinidad and Tobago", "Tunisia", "Turkey", "Uganda", "Ukraine", "United Arab Emirates", "United Kingdom", "Uruguay", "Uzbekistan", "Vanuatu", "Vietnam", "Venezuela", "Yemen", "Zambia", "Zimbabwe"};

    private String stringy;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_covid);
        rec = findViewById(R.id.recovered);
        conf = findViewById(R.id.confirmed_cases);
        dead = findViewById(R.id.death);
        menu = findViewById(R.id.imageView);
        open = findViewById(R.id.button5);
        spinner = findViewById(R.id.choosecountry);


        Paper.init(this);
        ArrayAdapter arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, countries);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CovidActivity.this, MainActivity.class));
            }
        });

        open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CovidActivity.this, EmptyCovidActivity.class));
            }
        });


        spinner = (Spinner) findViewById(R.id.choosecountry);

        spinner.setAdapter(arrayAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getBaseContext(), parent.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
                String text = parent.getSelectedItem().toString();
                OkHttpClient client = new OkHttpClient();
                String url = "https://covid-19-coronavirus-statistics.p.rapidapi.com/v1/total?country=" + text;

                Request request = new Request.Builder()
                        .url(url)
                        .get()
                        .addHeader("x-rapidapi-key", "9633ad985amsha46e65776a7ab0bp14198djsn93608365250f")
                        .addHeader("x-rapidapi-host", "covid-19-coronavirus-statistics.p.rapidapi.com")
                        .build();

                client.newCall(request).enqueue(new Callback() {
                    @Override
                    public void onFailure(@NotNull Call call, @NotNull IOException e) {
                        Toast.makeText(CovidActivity.this, "Error + ", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                        if (response.isSuccessful()){
                            Gson g = new Gson();
                            String resp = response.body().string();
                            Example example = g.fromJson(resp, Example.class);
                            CovidActivity.this.runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    String a = example.getData().getRecovered().toString();
                                    String b = example.getData().getDeaths().toString();
                                    String c = example.getData().getConfirmed().toString();
                                    rec.setText(a);
                                    dead.setText(b);
                                    conf.setText(c);
                                }
                            });
                        }
                    }



                });


            }


            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }


}