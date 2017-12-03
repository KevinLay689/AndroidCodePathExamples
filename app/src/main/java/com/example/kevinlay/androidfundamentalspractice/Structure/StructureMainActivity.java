package com.example.kevinlay.androidfundamentalspractice.Structure;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.kevinlay.androidfundamentalspractice.R;

public class StructureMainActivity extends AppCompatActivity {

    Button bEnterScreenRotation, bEnterPermission;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_structure_main);

        bEnterScreenRotation = (Button) findViewById(R.id.bEnterScreenRotation);
        bEnterScreenRotation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), ScreenRotationActivity.class);
                startActivity(i);
            }
        });

        bEnterPermission = (Button) findViewById(R.id.bEnterPermission);
        bEnterPermission.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), PermissionsActivity.class);
                startActivity(i);
            }
        });

    }
}
