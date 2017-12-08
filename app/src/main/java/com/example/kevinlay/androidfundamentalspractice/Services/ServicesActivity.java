package com.example.kevinlay.androidfundamentalspractice.Services;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.kevinlay.androidfundamentalspractice.R;

public class ServicesActivity extends AppCompatActivity {

    private MyTestReceiver receiverForTest;

    private Button bStartIntentServiceWithResultReceiver, bStartIntentServiceWithBroadcastReceiver, bStartIntentServiceWithAlarmManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services);

        bStartIntentServiceWithResultReceiver = (Button) findViewById(R.id.bStartIntentServiceWithResultReceiver);

        bStartIntentServiceWithResultReceiver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchTestService();
            }
        });

        bStartIntentServiceWithBroadcastReceiver = (Button) findViewById(R.id.bStartIntentServiceWithBroadcastReceiver);

        bStartIntentServiceWithBroadcastReceiver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onStartService(view);
            }
        });

        bStartIntentServiceWithAlarmManager = (Button) findViewById(R.id.bStartIntentServiceWithAlarmManager);

        bStartIntentServiceWithAlarmManager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               scheduleAlarm();
            }
        });

        setupServiceReceiver();

    }

    /**
        The following 2 methods are for using an Intent Receiver and Communicating with the Main Activity
        via a Result Receiver.
        These 2 methods also go with the MyTestReceiver and MyTestService classes

        Steps to create Intent Receiver and communicate with Result Receiver
            1. Create the Intent Receiver
            2. Create the Result Receiver
            3. Inside MainActivity pass the Intent receiver, an instance of the Result Receiver, with the callback method implemented
     */

    // This method defines how to execute the IntentService
    // Once you call startService() the intent runs the work inside onHandleIntent() and stops itself when its done
    public void launchTestService() {
        // Construct our Intent specifying the Service
        Intent i = new Intent(this, MyTestService.class);
        // Add extras to the bundle
        i.putExtra("foo", "bar");
        // Add the Result Receiver as a extra
        i.putExtra("receiver", receiverForTest);
        // Start the service
        startService(i);
    }

    // This defines the method callback that the service will call to perform actions on the activity
    public void setupServiceReceiver() {
        receiverForTest = new MyTestReceiver(new Handler());
        // This is where we specify what happens when data is received from the service
        receiverForTest.setReceiver(new MyTestReceiver.Receiver() {
            @Override
            public void onReceiveResult(int resultCode, Bundle resultData) {
                if (resultCode == RESULT_OK) {
                    String resultValue = resultData.getString("resultValue");
                    Toast.makeText(getApplicationContext(), resultValue, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    /**
        The following 4 methods are for executing a IntentService and communicating with a BroadcastReceiver
        These 2 methods go with MyBroadcastService

        Steps to create a IntentService with communication through Broadcast Receiver
            1. Create Intent Service
            2. Create a BroadcastReceiver in the MainActivity
                2a. Override its onReceive method to handle callback
            3. Inside MainActivity, in onResume, Create an IntentFilter for listening to the broadcast
               and use a LocalBroadcastManager to register the BroadcastReceiver with IntentFilter
            4. Unregister it in the unPause
     */

    // Launching the service
    public void onStartService(View v) {
        Intent i = new Intent(this, MyBroadcastService.class);
        i.putExtra("foo", "bar");
        startService(i);
    }

    @Override
    protected void onResume() {
        super.onResume();
        // Register for the particular broadcast based on ACTION string
        IntentFilter filter = new IntentFilter(MyBroadcastService.ACTION);
        LocalBroadcastManager.getInstance(this).registerReceiver(testReceiver, filter);
        // or `registerReceiver(testReceiver, filter)` for a normal broadcast
    }

    @Override
    protected void onPause() {
        super.onPause();
        // Unregister the listener when the application is paused
        LocalBroadcastManager.getInstance(this).unregisterReceiver(testReceiver);
        // or `unregisterReceiver(testReceiver)` for a normal broadcast
        cancelAlarm();
    }

    // Define the callback for what to do when data is received
    private BroadcastReceiver testReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            int resultCode = intent.getIntExtra("resultCode", RESULT_CANCELED);
            if (resultCode == RESULT_OK) {
                String resultValue = intent.getStringExtra("resultValue");
                Toast.makeText(ServicesActivity.this, resultValue, Toast.LENGTH_SHORT).show();
            }
        }
    };

    /**
        The following 2 classes are in conjunction with the PeriodicService and MyAlarmReceiver class
        Steps to Achieve a scheduler that triggers a background service at a regular interval
            1. Create the Intent Service
            2. Create the Broadcast Receiver
                2a. The Broadcast Receiver will fire the intent service in its onReceive method
            3. Register both in the manifest
                3a. BroadcastReceiver needs property -> android:process=":remote" so that it will run in a separate process so that it will continue to stay alive if the app has closed
            4. Create the AlarmManager in MainActivity, having it periodically call the pendingIntent

     */

    public void cancelAlarm() {
        Intent intent = new Intent(getApplicationContext(), MyAlarmReceiver.class);
        final PendingIntent pIntent = PendingIntent.getBroadcast(this, MyAlarmReceiver.REQUEST_CODE,
                intent, PendingIntent.FLAG_UPDATE_CURRENT);
        AlarmManager alarm = (AlarmManager) this.getSystemService(Context.ALARM_SERVICE);
        alarm.cancel(pIntent);
    }

    // Setup a recurring alarm every half hour
    private void scheduleAlarm() {
        // Construct an intent that will execute the AlarmReceiver
        Intent intent = new Intent(getApplicationContext(), MyAlarmReceiver.class);
        // Create a PendingIntent to be triggered when the alarm goes off
        final PendingIntent pIntent = PendingIntent.getBroadcast(this, MyAlarmReceiver.REQUEST_CODE,
                intent, PendingIntent.FLAG_UPDATE_CURRENT);
        // Setup periodic alarm every every half hour from this point onwards
        long firstMillis = System.currentTimeMillis(); // alarm is set right away
        AlarmManager alarm = (AlarmManager) this.getSystemService(Context.ALARM_SERVICE);
        // First parameter is the type: ELAPSED_REALTIME, ELAPSED_REALTIME_WAKEUP, RTC_WAKEUP
        // Interval can be INTERVAL_FIFTEEN_MINUTES, INTERVAL_HALF_HOUR, INTERVAL_HOUR, INTERVAL_DAY
        alarm.setInexactRepeating(AlarmManager.RTC_WAKEUP, firstMillis,
                AlarmManager.INTERVAL_FIFTEEN_MINUTES, pIntent);
    }

}
