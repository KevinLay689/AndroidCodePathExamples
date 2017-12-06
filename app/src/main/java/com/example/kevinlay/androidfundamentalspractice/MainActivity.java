package com.example.kevinlay.androidfundamentalspractice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.kevinlay.androidfundamentalspractice.AdapterViews.AdapterViewActivity;
import com.example.kevinlay.androidfundamentalspractice.DataPersistence.DataPersistenceActivity;
import com.example.kevinlay.androidfundamentalspractice.DesigningAndStylingViews.DesigningAndStylingViewActivity;
import com.example.kevinlay.androidfundamentalspractice.Fragments.FragmentsActvity;
import com.example.kevinlay.androidfundamentalspractice.Structure.StructureMainActivity;
import com.example.kevinlay.androidfundamentalspractice.ViewsAndLayouts.ViewsAndLayoutsActivity;

public class MainActivity extends AppCompatActivity {

    private Button bEnterStructureActivity, bEnterVlActivity, bEnterDesignActivity, bEnterAdapterViews,
                    bEnterDataPersistence, bEnterFragments;

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
        bEnterVlActivity = (Button) findViewById(R.id.bEnterViewsAndLayoutActivity);
        bEnterVlActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), ViewsAndLayoutsActivity.class);
                startActivity(i);
            }
        });
        bEnterDesignActivity = (Button) findViewById(R.id.bEnterDesignActivity);
        bEnterDesignActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), DesigningAndStylingViewActivity.class);
                startActivity(i);
            }
        });
        bEnterAdapterViews = (Button) findViewById(R.id.bEnterAdapterViews);
        bEnterAdapterViews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), AdapterViewActivity.class);
                startActivity(i);
            }
        });

        bEnterDataPersistence = (Button) findViewById(R.id.bEnterDataPersistence);
        bEnterDataPersistence.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), DataPersistenceActivity.class);
                startActivity(i);
            }
        });

        bEnterFragments = (Button) findViewById(R.id.bEnterFragments);
        bEnterFragments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), FragmentsActvity.class);
                startActivity(i);
            }
        });
    }
}
