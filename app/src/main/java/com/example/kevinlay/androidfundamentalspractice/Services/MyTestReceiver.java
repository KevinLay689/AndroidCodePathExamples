package com.example.kevinlay.androidfundamentalspractice.Services;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;


/**
 * Result Receiver
 *
 * Major Takeaways
 * -Don't override the support library one
 * -Manages communication via method callbacks
 * -When we want to trigger the service to start, pass the IntentService a reference to the reciever and setup its callback interface method
 *
 *
 */

public class MyTestReceiver extends ResultReceiver {
    private Receiver receiver;

    // Constructor takes a handler
    public MyTestReceiver(Handler handler) {
        super(handler);
    }

    // Setter for assigning the receiver
    public void setReceiver(Receiver receiver) {
        this.receiver = receiver;
    }

    // Defines our event interface for communication
    public interface Receiver {
        void onReceiveResult(int resultCode, Bundle resultData);
    }

    // Delegate method which passes the result to the receiver if the receiver has been assigned
    @Override
    protected void onReceiveResult(int resultCode, Bundle resultData) {
        if (receiver != null) {
            receiver.onReceiveResult(resultCode, resultData);
        }
    }
}
