package com.example.kevinlay.androidfundamentalspractice.Services;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;

import java.util.Random;

/**
 * Bound Service
 *
 * -A bound service is an implementation of the Service class that allows other applications to
 * bind to it and interact with it.
 * -To provide binding for a service, you must implement the onBind() callback method.
 *
 * -2 Options for creating a Bound Service
 *      1. Extending Binder
 *          1a. If your service is private to your own application and runs in the same process as the client
 *          (which is common), you should create your interface by extending the Binder class and returning
 *          an instance of it from onBind().
 *      2. Using a Messenger
 *          2a. If you need your interface to work across different processes, you can create an interface
 *          for the service with a Messenger.
 *
 * Steps to creating a Bound Service by extending Binder class
 *      1. Create an instance of Binder that does one of the following:
 *          1a. Contain public methods the client can call
 *          1b. Returns current Service instance which has public methods that can be called
 *          1c. Return an instance of another class hosted by the service with public methods it can call
 *      2. Return this instance of Binder from onBind()
 *      3. In the client, receive the Binder from the onServiceConnected() callback method and make
 *      calls to the bound service using the methods provided.
 *
 */

public class MyBoundService extends Service {

    // Binder given to clients
    private final IBinder mBinder = new LocalBinder();
    // Random number generator
    private final Random mGenerator = new Random();

    /**
     * Class used for the client Binder.  Because we know this service always
     * runs in the same process as its clients, we don't need to deal with IPC.
     *
     * This class provides a way for clients to retrieve the current instance and use the public
     * methods like getRandomNumber
     */
    public class LocalBinder extends Binder {
        MyBoundService getService() {
            // Return this instance of LocalService so clients can call public methods
            return MyBoundService.this;
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }

    /** method for clients */
    public int getRandomNumber() {
        return mGenerator.nextInt(100);
    }
}
