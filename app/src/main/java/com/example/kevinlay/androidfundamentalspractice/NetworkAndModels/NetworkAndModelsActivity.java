package com.example.kevinlay.androidfundamentalspractice.NetworkAndModels;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.kevinlay.androidfundamentalspractice.R;
import com.example.kevinlay.androidfundamentalspractice.Structure.PermissionsActivity;
import com.example.kevinlay.androidfundamentalspractice.Structure.ScreenRotationActivity;

public class NetworkAndModelsActivity extends AppCompatActivity {

    Button bEnterOkhttp, bEnterRetrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_network_and_models);

        bEnterOkhttp = (Button) findViewById(R.id.bEnterOkhttp);
        bEnterOkhttp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), OkHttpActivity.class);
                startActivity(i);
            }
        });

        bEnterRetrofit = (Button) findViewById(R.id.bEnterRetrofit);
        bEnterRetrofit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), RetrofitActivity .class);
                startActivity(i);
            }
        });

    }
}
