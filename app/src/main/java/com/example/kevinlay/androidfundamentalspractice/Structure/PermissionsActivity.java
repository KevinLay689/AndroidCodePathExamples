package com.example.kevinlay.androidfundamentalspractice.Structure;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.kevinlay.androidfundamentalspractice.R;

/**
 * This Activity requests Microphone and Contact access at runtime
 *
 * Major Takeaways from this:
 *  Check for permissions by using ContextCompat.checkSelfPermission, it will return granted or denied
 *  If access is denied, invoke ActivityCompat.requestPermissions to call onRequestPermissionsResult
 *  The request code is equal to the contact code you sent in through requestPermissions
 *  Grant results array contains the where the permission is saved
 *
 *
 *  Steps to requesting permissions
 *      1. Call ContextCompat.checkSelfPermission(context, Mainfest.permission.xxxx)
 *      2. Check if the permission is PackageManager.PERMISSION_GRANTED
 *      3. If permission is not granted, invoke:
 *      ActivityCompat.requestPermission(context, stringArrayOfPermissionsRequested[], someKey)
 *      4. Override onRequestPermissionsResult and perform a switch on requestCode and check if the
 *      grantResults[] > 0 and if it contains Permission Granted
 */

public class PermissionsActivity extends AppCompatActivity {

    private static final int READ_CONTACTS_PERMISSIONS_REQUEST = 1;
    private static final int RECORD_AUDIO_PERMISSIONS_REQUEST = 2;

    Button bRequestContacts, bRequestMicrophone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permissions);

        bRequestContacts = (Button) findViewById(R.id.bRequestContacts);
        bRequestMicrophone = (Button) findViewById(R.id.bRequestMicrophone);

        bRequestContacts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                requestContactPermission();
            }
        });

        bRequestMicrophone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                requestMicrophonePermission();
            }
        });
    }

    private void requestContactPermission() {

        int permissionCheck = ContextCompat.checkSelfPermission(this,
                Manifest.permission.READ_CONTACTS);

        if(permissionCheck != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.READ_CONTACTS},
                    READ_CONTACTS_PERMISSIONS_REQUEST);
        }
    }

    private void requestMicrophonePermission() {

        int permissionCheck = ContextCompat.checkSelfPermission(this,
                Manifest.permission.RECORD_AUDIO);

        if(permissionCheck != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.RECORD_AUDIO},
                    RECORD_AUDIO_PERMISSIONS_REQUEST);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        switch (requestCode) {
            case READ_CONTACTS_PERMISSIONS_REQUEST: {
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(this, "Contact Permission Granted", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(this, "Contact Permission Denied", Toast.LENGTH_LONG).show();
                }
                break;
            }
            case RECORD_AUDIO_PERMISSIONS_REQUEST: {
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(this, "Microphone Permission Granted", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(this, "Microphone Permission Denied", Toast.LENGTH_LONG).show();
                }
                break;
            }

        }

    }
}
