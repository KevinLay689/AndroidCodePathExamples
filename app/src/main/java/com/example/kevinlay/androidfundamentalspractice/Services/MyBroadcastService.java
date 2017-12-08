package com.example.kevinlay.androidfundamentalspractice.Services;

import android.app.Activity;
import android.app.IntentService;
import android.content.Intent;
import android.os.SystemClock;
import android.support.v4.content.LocalBroadcastManager;

/**
 * Intent Service for communication through a Broadcast Receier
 *
 * Major Takeaways
 * -The sendBroadcast() method sends out the broadcast to any applications that wants to listen to it
 * -The Intent(Action) is what the LocalBroadcastManager is emitting
 * -To catch the broadcast, must register a receiver with the IntentFilter the same as the Action the broadCast is emitting
 *   Ex
 *         IntentFilter filter = new IntentFilter(MyTestService.ACTION);
 *         LocalBroadcastManager.getInstance(this).registerReceiver(testReceiver, filter);
 * -The testReceiver will override onReceive to handle the broadcast data
 */
public class MyBroadcastService extends IntentService {

    public static final String ACTION = "com.example.kevinlay.androidfundamentalspractice.Services.MyBroadcastService";


    public MyBroadcastService() {
        super("test-service");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        // Fetch data passed into the intent on start
        String val = intent.getStringExtra("foo");
        // Construct an Intent tying it to the ACTION (arbitrary event namespace)
        Intent in = new Intent(ACTION);
        // Put extras into the intent as usual
        in.putExtra("resultCode", Activity.RESULT_OK);
        in.putExtra("resultValue", "My Result Value. Passed in: " + val);
        SystemClock.sleep(2000);
        // Fire the broadcast with intent packaged
        LocalBroadcastManager.getInstance(this).sendBroadcast(in);
        // or sendBroadcast(in) for a normal broadcast;
    }
}
