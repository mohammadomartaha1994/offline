package com.kafrmalik.mohammad.internatoffline;

/**
 * Created by mohammad on 10/11/2017.
 */

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.widget.Toast;


public class AlertReceier extends BroadcastReceiver{
    public AlertReceier(){
    }
    @Override
    public void onReceive(Context context, Intent intent) {

        if(intent.getAction().equalsIgnoreCase("com.test.internetoffline")){

              Savedata savedata = new Savedata(context);

                if(savedata.isInternetConnected(context))
                {savedata.printY();}
                else
                {savedata.printN();}

        }
        else if (intent.getAction().equalsIgnoreCase("android.intent.action.BOOT_COMPLETED")){

            Savedata savedata = new Savedata(context);
            savedata.again();

        }
    }
}