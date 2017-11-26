package com.example.kevinlay.androidfundamentalspractice.Structure;

import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.kevinlay.androidfundamentalspractice.R;

public class ScreenRotationActivity extends AppCompatActivity {

    private static final String TAG = "ScreenRotationActivity";

    private Button bSave;
    private TextView tvValueHolder;
    private EditText etInput;

    private String screenRotationSavedValueKey = "savedValueKey";
    private String screenRotationSavedValue = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_rotation);

        bSave = (Button) findViewById(R.id.bSaveScreenRotation);
        tvValueHolder = (TextView) findViewById(R.id.tvScreenRotationText);
        etInput = (EditText) findViewById(R.id.etScreenRotation);

        bSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                screenRotationSavedValue = etInput.getText().toString();
                tvValueHolder.setText(R.string.screen_rotation_textview_saved_text);
                Log.i(TAG, "onSaveInstanceState: Saved value is:  "+  screenRotationSavedValue );
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        tvValueHolder.setText(screenRotationSavedValue);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        screenRotationSavedValue = savedInstanceState.getString(screenRotationSavedValueKey);
        tvValueHolder.setText(screenRotationSavedValue);
        Log.i(TAG, "onRestoreInstanceState: " + screenRotationSavedValue);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(screenRotationSavedValueKey, screenRotationSavedValue);
        Log.i(TAG, "onSaveInstanceState: " + screenRotationSavedValueKey);
    }
}
