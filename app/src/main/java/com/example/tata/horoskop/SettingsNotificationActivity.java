package com.example.tata.horoskop;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SwitchCompat;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Calendar;

public class SettingsNotificationActivity extends AppCompatActivity implements View.OnClickListener {
    Toolbar toolbar;
    SwitchCompat switchCompat;
    AlarmManager am;
    PendingIntent pendingIntent;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_notification_activity);
        editor = getSharedPreferences("notification", MODE_PRIVATE).edit();
        sharedPreferences = getSharedPreferences("notification", MODE_PRIVATE);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        switchCompat = (SwitchCompat) findViewById(R.id.sw_notification);

        switchCompat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    settingNotification();
                    editor.putBoolean("checked", true);
                    editor.apply();
                    Toast.makeText(SettingsNotificationActivity.this, "Notifications turned on", Toast.LENGTH_SHORT).show();
                } else {
                    if (am != null) {
                        am.cancel(pendingIntent);
                        am = null;
                        editor.putBoolean("checked", false);
                        editor.apply();
                        Toast.makeText(SettingsNotificationActivity.this, "Notifications turned off", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        ImageView btnBack = (ImageView) findViewById(R.id.btnBack);
        btnBack.setOnClickListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        boolean checked = sharedPreferences.getBoolean("checked", false);
        if (checked) {
            switchCompat.setChecked(true);
        } else {
            switchCompat.setChecked(false);
        }
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnBack) {
            super.onBackPressed();
        }
    }

    private void settingNotification() {
        Intent intent = new Intent(SettingsNotificationActivity.this, Receiver.class);
        pendingIntent = PendingIntent.getBroadcast(SettingsNotificationActivity.this, 0, intent, 0);
        am = (AlarmManager) getSystemService(ALARM_SERVICE);
        // Set the alarm to start at approximately 10:45 p.m.
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.set(Calendar.HOUR_OF_DAY, 10);
        calendar.set(Calendar.MINUTE, 45);


        // With setInexactRepeating(), you have to use one of the AlarmManager interval
        // constants--in this case, AlarmManager.INTERVAL_DAY.
        am.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),
                AlarmManager.INTERVAL_DAY, pendingIntent);

    }
}
