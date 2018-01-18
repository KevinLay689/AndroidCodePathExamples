package com.example.kevinlay.androidfundamentalspractice.kotlin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.kevinlay.androidfundamentalspractice.R;

public class KotlinActivity extends AppCompatActivity {

    private static final String TAG = "KotlinActivity";

    private TextView tvKotlin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kotlin);

        tvKotlin = (TextView) findViewById(R.id.tvKotlin);

        UserK userK = new UserK("This user was created using a Kotlin class", 100);
        tvKotlin.setText(userK.showDetails());

        Log.i(TAG, "onCreate: "+ userK.showDetails());
        Log.i(TAG, "onCreate: "+ userK.p());
    }
}
