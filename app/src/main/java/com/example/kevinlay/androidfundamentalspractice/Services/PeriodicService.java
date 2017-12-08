package com.example.kevinlay.androidfundamentalspractice.Services;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by kevinlay on 12/7/17.
 */

public class PeriodicService extends IntentService {

    public PeriodicService() {
        super("MyTestService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        // Do the task here
        Log.i("PeriodicService", "Service running");
    }
}
