package com.example.kevinlay.androidfundamentalspractice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.kevinlay.androidfundamentalspractice.Structure.StructureMainActivity;

public class MainActivity extends AppCompatActivity {

    private Button bEnterStructureActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bEnterStructureActivity = (Button) findViewById(R.id.bEnterStructureActivity);
        bEnterStructureActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), StructureMainActivity.class);
                startActivity(i);
            }
        });
    }
}
