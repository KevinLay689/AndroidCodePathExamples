package com.example.kevinlay.androidfundamentalspractice.DataPersistence;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kevinlay.androidfundamentalspractice.R;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Internal Storage Activity
 *
 * Major Takeaways
 *
 * -Adding and removing is typical java i/o nothing really special
 * -Adding To Internal Storage
 *      1. Create a fileOutputStream and open the fileName
 *      2. Call fileOutputStream.write(message.getBytes());
 *      3. Close the OutputStream
 *
 * -Loading Internal Storage
 *      1. Create FileInputStream and open the fileName
 *      2. Read the input of FileInputStream into a InputStreamReader
 *      3. Make a bufferedReader that can read the new InputStreamReader
 *      4. Go line by line into the bufferedReader and read the data
 */
public class InternalStorageActivity extends AppCompatActivity {

    private Button bLoadInternalStorage, bAddInternalStorage;
    private EditText etInternalStorageMessage, etInternalStorageFileName;
    private TextView tvInternalStorageTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_internal_storage);

        bLoadInternalStorage = (Button) findViewById(R.id.bLoadInternalStorage);
        bAddInternalStorage = (Button) findViewById(R.id.bAddInternalStorage);
        etInternalStorageMessage = (EditText) findViewById(R.id.etInternalStorageMessage);
        etInternalStorageFileName = (EditText) findViewById(R.id.etInternalStorageFileName);
        tvInternalStorageTextView = (TextView) findViewById(R.id.tvInternalStorageTextView);

        bLoadInternalStorage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadInternalStorage(etInternalStorageFileName.getText().toString());
            }
        });

        bAddInternalStorage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addInternalStorage(etInternalStorageFileName.getText().toString(), etInternalStorageMessage.getText().toString());
            }
        });
    }

    private void addInternalStorage(String fileName, String message) {

        try {
            String successMessage = "Message Added";
            FileOutputStream fileOutputStream = openFileOutput(fileName, MODE_PRIVATE);
            fileOutputStream.write(message.getBytes());
            fileOutputStream.close();
            makeToastMsg(successMessage);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadInternalStorage(String fileName) {

        try {
            String message;
            FileInputStream fileInputStream = openFileInput(fileName);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            StringBuffer buffer = new StringBuffer();
            while ((message = bufferedReader.readLine()) != null) {
                buffer.append(message + "\n");
            }

            tvInternalStorageTextView.setText(buffer.toString());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void makeToastMsg(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }
}
