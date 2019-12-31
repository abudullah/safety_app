package com.example.myapplication;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.telephony.SmsManager;
import android.util.Log;
import android.widget.Toast;

public class someone extends BroadcastReceiver {
    second j;
    massage b;
    database c = b.a;
    String num;

    private static int countPowerOff = 0;

    public someone() {

    }

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(Intent.ACTION_SCREEN_OFF)) {
            Log.e("In on receive", "In Method:  ACTION_SCREEN_OFF");
            countPowerOff++;
        } else if (intent.getAction().equals(Intent.ACTION_SCREEN_ON)) {
            Log.e("In on receive", "In Method:  ACTION_SCREEN_ON");
        } else if (intent.getAction().equals(Intent.ACTION_USER_PRESENT)) {
            Log.e("In on receive", "In Method:  ACTION_USER_PRESENT");
            if (countPowerOff > 2) {

                Cursor res = c.getAllData();
                if (res.getCount() == 0) {
                    // show message

                    return;
                }

                // StringBuffer buffer = new StringBuffer();
                while (res.moveToNext()) {


                    try {
                        num = res.getString(1);
                        num = '0' + num;


                    } catch (Exception e) {

                    }

                    String massag = LocationListeningCallback.lastLocation.getLatitude() + " " + LocationListeningCallback.lastLocation.getLongitude();
                    String scAddress = null;
                    PendingIntent sentIntent = null, deliveryIntent = null;

                    SmsManager smsManager = SmsManager.getDefault();
                    try {
                        smsManager.sendTextMessage
                                (num, scAddress, massag,
                                        sentIntent, deliveryIntent);

                    } catch (Exception e) {


                    }


                    countPowerOff = 0;


                }
            }
        }
    }
}
