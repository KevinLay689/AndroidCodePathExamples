package com.example.kevinlay.androidfundamentalspractice.DataPersistence;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.kevinlay.androidfundamentalspractice.AdapterViews.AdapterViewActivity;
import com.example.kevinlay.androidfundamentalspractice.DesigningAndStylingViews.DesigningAndStylingViewActivity;
import com.example.kevinlay.androidfundamentalspractice.R;
import com.example.kevinlay.androidfundamentalspractice.Structure.StructureMainActivity;
import com.example.kevinlay.androidfundamentalspractice.ViewsAndLayouts.ViewsAndLayoutsActivity;

public class DataPersistenceActivity extends AppCompatActivity {

    private Button bEnterSharedPref, bEnterInternalStorage, bEnterExternalStorage, bEnterSqliteDatabase, bEnterContentProvider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_persistence);

        bEnterSharedPref = (Button) findViewById(R.id.bEnterSharedPref);
        bEnterSharedPref.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), SharedPreferencesActivity.class);
                startActivity(i);
            }
        });
        bEnterInternalStorage = (Button) findViewById(R.id.bEnterInternalStorage);
        bEnterInternalStorage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), InternalStorageActivity.class);
                startActivity(i);
            }
        });
        bEnterExternalStorage = (Button) findViewById(R.id.bEnterExternalStorage);
        bEnterExternalStorage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), ExternalStorageActivity.class);
                startActivity(i);
            }
        });
        bEnterSqliteDatabase = (Button) findViewById(R.id.bEnterSqliteDatabase);
        bEnterSqliteDatabase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), SqliteDatabaseActivity.class);
                startActivity(i);
            }
        });
        bEnterContentProvider = (Button) findViewById(R.id.bEnterContentProvider);
        bEnterContentProvider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), ContentProviderActivity.class);
                startActivity(i);
            }
        });
    }
}
