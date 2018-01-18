package com.example.kevinlay.androidfundamentalspractice.kotlin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.kevinlay.androidfundamentalspractice.R;

public class KotlinActivity extends AppCompatActivity {

    private static final String TAG = "KotlinActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kotlin);
        UserK userK = new UserK("test", 100);

        Log.i(TAG, "onCreate: "+ userK.showDetails());
    }
}
