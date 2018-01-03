package com.example.kevinlay.androidfundamentalspractice.Services;

import android.app.Activity;
import android.app.IntentService;
import android.content.Intent;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.os.SystemClock;
import android.support.annotation.Nullable;

/**
 * Intent Service
 *
 * Major Takeaways
 * -Must subclass IntentService and do 2 things
 *      1. Default constructor, calls super("") with some string that names background thread
 *      2. Override onHandleIntent - runs when startService(intent) is called
 * -Must register Intent Service in Manifest
 *      1. Export property defines if the service can be executed by other applications
 * -Communication back to the app done in 2 days
 *      1. ResultReceiver - Use if your service only needs to connect with its parent application in a single place
 *      2. BroadcastReceiver - Use if your service needs to communicate with multiple components that want to listen for communication
 *
 */

public class MyTestService extends IntentService {

    public MyTestService() {
        // Used to name the worker thread, important only for debugging.
        super("test-service");
    }

    // Creating a service
    public MyTestService(String name) {
        // Used to name the worker thread, important only for debugging.
        super(name);
    }

    @Override
    public void onCreate() {
        super.onCreate(); // if you override onCreate(), make sure to call super().
        // If a Context object is needed, call getApplicationContext() here.
    }


    // This method describes what will happen when startService is called from the activity
    @Override
    protected void onHandleIntent(Intent intent) {
        // Extract the receiver passed into the service
        ResultReceiver rec = intent.getParcelableExtra("receiver");
        // Extract additional values from the bundle
        String val = intent.getStringExtra("foo");
        // To send a message to the Activity, create a pass a Bundle
        Bundle bundle = new Bundle();
        bundle.putString("resultValue", "My Result Value. Passed in: " + val);
        // This will mimock some data being processed
        SystemClock.sleep(2000);
        // Here we call send passing a resultCode and the bundle of extras
        rec.send(Activity.RESULT_OK, bundle);
    }

}
