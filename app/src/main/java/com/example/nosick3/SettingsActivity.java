package com.example.nosick3;

import androidx.annotation.ColorInt;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;
import androidx.cardview.widget.CardView;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.ColorSpace;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RemoteViews;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.Set;

import io.paperdb.Paper;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import static androidx.core.app.NotificationCompat.PRIORITY_HIGH;


public class SettingsActivity extends AppCompatActivity {
    NotificationManagerCompat notificationManager;
    private static final int NOTIFY_ID = 1;
    private static final String CHANNEL_ID = "NOTIFICATION_ID";
    SwitchCompat notification;
    TextView confirmed;
    CardView switcher;
    TextView died;
    TextView recovered;
    Spinner spinner;
    private String[] countries = {"Russia", "Afghanistan", "Albania", "Algeria", "Andorra", "Angola", "Antigua and Barbuda", "Argentina", "Armenia", "Australia", "Austria", "Azerbaijan", "Bangladesh", "Barbados", "Bahamas", "Bahrain", "Belarus", "Belgium", "Belize", "Benin", "Bhutan", "Bolivia", "Bosnia and Herzegovina", "Botswana", "Brazil", "British Virgin Islands", "Bulgaria", "Burkina Faso", "Burma", "Burundi", "Cambodia", "Cameroon", "Canada", "Central African Republic", "Chad", "Chile", "China", "Colombia", "Comoros", "Costa Rica", "Croatia", "Cyprus", "Czech Republic", "Denmark", "Dominica", "Dominican Republic", "Ecuador", "El Salvador", "Egypt", "Equatorial Guinea", "Eritrea", "Estonia", "Ethiopia", "Fiji", "Finland", "France", "Gabon", "Gambia", "Georgia", "Germany", "Ghana", "Greece", "Grenada", "Guatemala", "Guinea", "Guinea-Bissau", "Guyana", "Haiti", "Honduras", "Hungary", "Iceland", "India", "Indonesia", "Iraq", "Ireland", "Israel", "Italy", "Jamaica", "Japan", "Jordan", "Kazakhstan", "Kenya", "Kiribati", "Kuwait", "Kyrgyzstan", "Laos", "Latvia", "Lebanon", "Lesotho", "Liberia", "Libya", "Liechtenstein", "Lithuania", "Luxembourg", "Madagascar", "Malawi", "Malaysia", "Maldives", "Mali", "Malta", "Marshall Islands", "Mauritania", "Mauritius", "Mexico", "Moldova", "Monaco", "Mongolia", "Montenegro", "Morocco", "Mozambique", "Namibia", "Nepal", "Netherlands", "New Zealand", "Nicaragua", "Niger", "Nigeria", "Norway", "Oman", "Pakistan", "Palau", "Panama", "Papua New Guinea", "Paraguay", "Peru", "Philippines", "Poland", "Portugal", "Qatar", "Romania", "Rwanda", "Saint Kitts and Nevis", "Saint Lucia", "Samoa", "San Marino", "Saudi Arabia", "Senegal", "Serbia", "Seychelles", "Sierra Leone", "Singapore", "Slovakia", "Slovenia", "Solomon Islands", "Somalia", "South Africa", "Spain", "Sri Lanka", "Sudan", "Suriname", "Sweden", "Switzerland", "Syria", "Tajikistan", "Tanzania", "Thailand", "Togo", "Trinidad and Tobago", "Tunisia", "Turkey", "Uganda", "Ukraine", "United Arab Emirates", "United Kingdom", "Uruguay", "Uzbekistan", "Vanuatu", "Vietnam", "Venezuela", "Yemen", "Zambia", "Zimbabwe"};


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        notification = findViewById(R.id.switch_on);
        confirmed = findViewById(R.id.confirmed_cases_exp);
        died = findViewById(R.id.death_exp);
        recovered = findViewById(R.id.recovered_exp);

        Paper.init(this);
        ArrayAdapter arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, countries);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        notificationManager = NotificationManagerCompat.from(this);

        notification.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){

                    switcher = findViewById(R.id.cardViewSwitcher);
                    switcher.setVisibility(View.VISIBLE);
                    spinner = (Spinner) findViewById(R.id.sp);

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
                                    Toast.makeText(SettingsActivity.this, "Error + ", Toast.LENGTH_SHORT).show();
                                }

                                @Override
                                public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                                    if (response.isSuccessful()){
                                        Gson g = new Gson();
                                        String resp = response.body().string();
                                        Example example = g.fromJson(resp, Example.class);
                                        SettingsActivity.this.runOnUiThread(new Runnable() {
                                            @Override
                                            public void run() {
                                                String a = example.getData().getRecovered().toString();
                                                String b = example.getData().getDeaths().toString();
                                                String c = example.getData().getConfirmed().toString();
                                                Intent intent = new Intent(SettingsActivity.this, Notification_exp.class);
                                                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                                                RemoteViews normal = new RemoteViews(getPackageName(), R.layout.notification_normal);
                                                RemoteViews expanded = new RemoteViews(getPackageName(), R.layout.activity_notification_exp);
                                                PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(), 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
                                                Notification notificationBuilder = new NotificationCompat.Builder(getApplicationContext(), CHANNEL_ID)
                                                        .setSmallIcon(R.drawable.virusi)
                                                        .setContentTitle("Статистика")
                                                        .setStyle(new NotificationCompat.InboxStyle()
                                                            .addLine("Выздоровело " + a)
                                                            .addLine("Умерло " + b)
                                                            .addLine("Выздоровело " + c))
                                                        .setPriority(PRIORITY_HIGH)
                                                        .build();
                                                notificationManager.notify(1, notificationBuilder);
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


                }else{
                    switcher = findViewById(R.id.cardViewSwitcher);
                    switcher.setVisibility(View.INVISIBLE);
                    notificationManager.cancelAll();
                }
            }
        });
    }


    public static void createChannelIfNeeded(NotificationManager manager){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel notificationChannel = new NotificationChannel(CHANNEL_ID, CHANNEL_ID, NotificationManager.IMPORTANCE_DEFAULT);
            manager.createNotificationChannel(notificationChannel);
        }
    }



}