package com.example.kevinlay.androidfundamentalspractice.DataPersistence;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kevinlay.androidfundamentalspractice.R;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExternalStorageActivity extends AppCompatActivity {

    private Button bLoadExternalStorage, bAddExternalStorage;
    private EditText etExternalStorageMessage, etExternalStorageFileName;
    private TextView tvExternalStorageTextView;

    private String filename = "SampleFile.txt";
    private String filepath = "MyFileStorage";
    File myExternalFile;
    String myData = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_external_storage);

        bLoadExternalStorage = (Button) findViewById(R.id.bLoadExternalStorage);
        bAddExternalStorage = (Button) findViewById(R.id.bAddExternalStorage);
        etExternalStorageMessage = (EditText) findViewById(R.id.etExternalStorageMessage);
        etExternalStorageFileName = (EditText) findViewById(R.id.etExternalStorageFileName);
        tvExternalStorageTextView = (TextView) findViewById(R.id.tvExternalStorageTextView);

        bLoadExternalStorage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myExternalFile = new File(getExternalFilesDir(filepath), etExternalStorageFileName.getText().toString());
                loadExternalStorage(etExternalStorageFileName.getText().toString());
            }
        });

        bAddExternalStorage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myExternalFile = new File(getExternalFilesDir(filepath), etExternalStorageFileName.getText().toString());
                addExternalStorage(etExternalStorageFileName.getText().toString(), etExternalStorageMessage.getText().toString());
            }
        });

        if (!isExternalStorageAvailable() || isExternalStorageReadOnly()) {
            bAddExternalStorage.setEnabled(false);
        }
        else {
            myExternalFile = new File(getExternalFilesDir(filepath), filename);
        }
    }

    private void addExternalStorage(String fileName, String message) {
        try {
            FileOutputStream fos = new FileOutputStream(myExternalFile);
            fos.write(message.getBytes());
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        etExternalStorageMessage.setText("");
        makeToastMsg("SampleFile.txt saved to External Storage...");
    }

    private void loadExternalStorage(String fileName) {
        try {
            FileInputStream fis = new FileInputStream(myExternalFile);
            DataInputStream in = new DataInputStream(fis);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine;
            while ((strLine = br.readLine()) != null) {
                myData = myData + strLine;
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        tvExternalStorageTextView.setText(myData);
        makeToastMsg("SampleFile.txt data retrieved from Internal Storage...");
    }

    private static boolean isExternalStorageReadOnly() {
        String extStorageState = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED_READ_ONLY.equals(extStorageState)) {
            return true;
        }
        return false;
    }

    private static boolean isExternalStorageAvailable() {
        String extStorageState = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(extStorageState)) {
            return true;
        }
        return false;
    }

    private void makeToastMsg(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }
}
