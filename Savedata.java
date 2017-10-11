package com.kafrmalik.mohammad.internatoffline;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static android.content.Context.ALARM_SERVICE;

public class Savedata {
    Context context;

    public Savedata(Context context) {
        this.context = context;
    }
    public void again(){
        int interval = 10000;
        Intent alertIntent = new Intent(context,AlertReceier.class);
        alertIntent.setAction("com.test.internetoffline");
        AlarmManager alarmManager = (AlarmManager)context.getSystemService(ALARM_SERVICE);
        Calendar cur_cal = new GregorianCalendar();
        alarmManager.setInexactRepeating(AlarmManager.RTC_WAKEUP,cur_cal.getTimeInMillis(),interval,
                PendingIntent.getBroadcast(context, 1,alertIntent,PendingIntent.FLAG_CANCEL_CURRENT));
    }


    public static boolean isInternetConnected(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        return activeNetwork != null && activeNetwork.isConnectedOrConnecting();
    }

    public void printN(){
        Toast.makeText(context,"no internet connection",Toast.LENGTH_LONG).show();
    }

    public void printY(){
        Toast.makeText(context,"connected",Toast.LENGTH_LONG).show();
    }

}

