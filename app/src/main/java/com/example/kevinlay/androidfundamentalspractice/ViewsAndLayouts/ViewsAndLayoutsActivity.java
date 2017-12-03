package com.example.kevinlay.androidfundamentalspractice.ViewsAndLayouts;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.kevinlay.androidfundamentalspractice.R;
import com.example.kevinlay.androidfundamentalspractice.Structure.StructureMainActivity;

public class ViewsAndLayoutsActivity extends AppCompatActivity {

    private Button bEnterTextViewActivity, bEnterEditTextActivity, bEnterImageViewActivity, bEnterInputViewActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_views_and_layouts);

        bEnterTextViewActivity = (Button) findViewById(R.id.bEnterTextViewActivity);
        bEnterTextViewActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), TextViewActivity.class);
                startActivity(i);
            }
        });
        bEnterEditTextActivity = (Button) findViewById(R.id.bEnterEditTextActivity);
        bEnterEditTextActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), EditTextActivity.class);
                startActivity(i);
            }
        });
        bEnterImageViewActivity = (Button) findViewById(R.id.bEnterImageViewActivity);
        bEnterImageViewActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), ImageViewActivity.class);
                startActivity(i);
            }
        });
        bEnterInputViewActivity = (Button) findViewById(R.id.bEnterInputViewActivity);
        bEnterInputViewActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), InputViewActivity.class);
                startActivity(i);
            }
        });
    }
}
