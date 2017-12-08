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

    // Launching the service
    public void onStartService(View v) {
        Intent i = new Intent(this, MyBroadcastService.class);
        i.putExtra("foo", "bar");
        startService(i);
    }

    // This method defines how to execute the IntentService
    // Once you call startService() the intent runs the work inside onHandleIntent() and stops itself when its done
    // Call `launchTestService()` in the activity
    // to startup the service
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
