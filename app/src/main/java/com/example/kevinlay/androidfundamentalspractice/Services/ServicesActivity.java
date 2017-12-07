package com.example.kevinlay.androidfundamentalspractice.Services;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.kevinlay.androidfundamentalspractice.R;

public class ServicesActivity extends AppCompatActivity {

    private MyTestReceiver receiverForTest;

    private Button bStartIntentServiceWithResultReceiver;

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

        setupServiceReceiver();

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
}
