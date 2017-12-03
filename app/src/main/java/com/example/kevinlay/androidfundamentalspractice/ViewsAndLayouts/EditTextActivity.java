package com.example.kevinlay.androidfundamentalspractice.ViewsAndLayouts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.kevinlay.androidfundamentalspractice.R;

/**
 * EditText Activity
 *
 * Major Takeaways
 * -Changing the inputType allows customization for input, can use multiple input types ex. android:inputType="textCapSentences|textMultiline"
 * -Lots of things that allow customization like digits, maxLength, etc
 * -To use Text Input Layout you must add design libraries
 *
 */

public class EditTextActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_text);
    }
}
