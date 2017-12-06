package com.example.kevinlay.androidfundamentalspractice.Fragments;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.kevinlay.androidfundamentalspractice.AdapterViews.AdapterViewActivity;
import com.example.kevinlay.androidfundamentalspractice.DataPersistence.DataPersistenceActivity;
import com.example.kevinlay.androidfundamentalspractice.DesigningAndStylingViews.DesigningAndStylingViewActivity;
import com.example.kevinlay.androidfundamentalspractice.R;
import com.example.kevinlay.androidfundamentalspractice.Structure.StructureMainActivity;
import com.example.kevinlay.androidfundamentalspractice.ViewsAndLayouts.ViewsAndLayoutsActivity;

public class FragmentsActvity extends AppCompatActivity {

    private Button bEnterCreateFragments, bEnterDialogFragment, bEnterViewPager, bEnterFlexibleUI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragments_actvity);

        bEnterCreateFragments = (Button) findViewById(R.id.bEnterCreateFragments);
        bEnterCreateFragments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), CreatingFragmentsActivity.class);
                startActivity(i);
            }
        });
        bEnterDialogFragment = (Button) findViewById(R.id.bEnterDialogFragment);
        bEnterDialogFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), DialogFragmentActivity.class);
                startActivity(i);
            }
        });
        bEnterViewPager = (Button) findViewById(R.id.bEnterViewPager);
        bEnterViewPager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), ViewPagerActvity.class);
                startActivity(i);
            }
        });
        bEnterFlexibleUI = (Button) findViewById(R.id.bEnterFlexibleUI);
        bEnterFlexibleUI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), FlexibleUIActivity.class);
                startActivity(i);
            }
        });
    }
}
