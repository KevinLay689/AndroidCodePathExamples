package com.example.kevinlay.androidfundamentalspractice.DataPersistence;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kevinlay.androidfundamentalspractice.R;

/**
 * Shared Preference Activity
 *
 * Major Takeaways
 * -Adding Shared Preferences
 *      1. Get reference to shared preference
 *          1a. Example SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(Context);
 *      2. Get reference to the editor of that shared preference object
 *          2a. Example SharedPreferences.Editor editor = sharedPreferences.edit();
 *      3. Use editor to add values
 *      4. Use editor.apply() to do asynchronous call to save data
 *
 * -Loading Shared Preference
 *      1. Get reference to shared preferences
 *          1a. Example SharedPreferences sharedPreference = PreferenceManager.getDefaultSharedPreferences(Context)
 *      2. Use sharedPreference.getString to retrieve value;
 *
 */

public class SharedPreferencesActivity extends AppCompatActivity {

    private Button bLoadSharedPreferences, bAddSharedPreferences;
    private EditText etSharedPrefKey, etSharedPrefValue;
    private TextView tvSharedPreferenceTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preferences);

        bLoadSharedPreferences = (Button) findViewById(R.id.bLoadSharedPreferences);
        bAddSharedPreferences = (Button) findViewById(R.id.bAddSharedPreferences);
        etSharedPrefKey = (EditText) findViewById(R.id.etSharedPrefKey);
        etSharedPrefValue = (EditText) findViewById(R.id.etSharedPrefValue);
        tvSharedPreferenceTextView = (TextView) findViewById(R.id.tvSharedPreferenceTextView);

        bLoadSharedPreferences.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadSharedPreferences(etSharedPrefKey.getText().toString());
            }
        });

        bAddSharedPreferences.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addSharedPreferences(etSharedPrefKey.getText().toString(), etSharedPrefValue.getText().toString());
            }
        });

    }

    private void addSharedPreferences(String key, String value) {
        String toastMsg = "Added Successfully";

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, value);
        editor.apply();

        makeToastMsg(toastMsg);

    }

    private void loadSharedPreferences(String key) {
        String keyNotFoundText = "No value found for key " + key;

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        String retrievedKey = sharedPreferences.getString(key, keyNotFoundText);

        tvSharedPreferenceTextView.setText(retrievedKey);
    }

    private void makeToastMsg(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }
}
