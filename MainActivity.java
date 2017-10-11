package com.kafrmalik.mohammad.internatoffline;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int interval = 10000;
        Intent alertIntent = new Intent(getApplicationContext(),AlertReceier.class);
        alertIntent.setAction("com.test.internetoffline");
        AlarmManager alarmManager = (AlarmManager)getSystemService(ALARM_SERVICE);
        Calendar cur_cal = new GregorianCalendar();
            alarmManager.setInexactRepeating(AlarmManager.RTC_WAKEUP,cur_cal.getTimeInMillis(),interval,
                    PendingIntent.getBroadcast(getApplicationContext(), 1,alertIntent,PendingIntent.FLAG_CANCEL_CURRENT));

    }
}