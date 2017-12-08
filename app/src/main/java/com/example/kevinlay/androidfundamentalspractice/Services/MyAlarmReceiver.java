package com.example.kevinlay.androidfundamentalspractice.Services;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by kevinlay on 12/7/17.
 */

public class MyAlarmReceiver extends BroadcastReceiver {
    public static final int REQUEST_CODE = 12345;
    public static final String ACTION = "com.example.kevinlay.androidfundamentalspractice.Services.MyAlarmReceiver";

    // Triggered by the Alarm periodically (starts the service to run task)
    @Override
    public void onReceive(Context context, Intent intent) {
        Intent i = new Intent(context, PeriodicService.class);
        i.putExtra("foo", "bar");
        context.startService(i);
    }
}
