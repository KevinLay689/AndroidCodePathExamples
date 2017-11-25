package com.example.kevinlay.androidfundamentalspractice.Structure;

import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.kevinlay.androidfundamentalspractice.R;

public class ScreenRotationActivity extends AppCompatActivity {

    private Button bSave;
    private TextView tvValueHolder;
    private EditText etInput;

    private String screenRotationSavedValueKey = "savedValueKey";
    private String screenRotationSavedValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_rotation);

        bSave = (Button) findViewById(R.id.bSaveScreenRotation);
        tvValueHolder = (TextView) findViewById(R.id.tvScreenRotationText);
        etInput = (EditText) findViewById(R.id.etScreenRotation);

        if(savedInstanceState != null) {
            screenRotationSavedValue = savedInstanceState.getString(screenRotationSavedValueKey);
        }

        bSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                screenRotationSavedValue = etInput.getText().toString();
                tvValueHolder.setText(screenRotationSavedValue);
            }
        });


    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {

        super.onSaveInstanceState(outState, outPersistentState);
        outState.putString(screenRotationSavedValue, screenRotationSavedValueKey);
    }
}
