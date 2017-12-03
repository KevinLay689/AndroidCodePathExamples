package com.example.kevinlay.androidfundamentalspractice.AdapterViews;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.kevinlay.androidfundamentalspractice.DesigningAndStylingViews.AnimationActivity;
import com.example.kevinlay.androidfundamentalspractice.DesigningAndStylingViews.DrawableActivity;
import com.example.kevinlay.androidfundamentalspractice.R;

public class AdapterViewActivity extends AppCompatActivity {

    private Button bEnterRecyclerView, bEnterCardView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adapter_view);


        bEnterRecyclerView = (Button) findViewById(R.id.bEnterRecyclerView);
        bEnterRecyclerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), RecyclerViewActivity.class);
                startActivity(i);
            }
        });

        bEnterCardView = (Button) findViewById(R.id.bEnterCardView);
        bEnterCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), CardViewActivity.class);
                startActivity(i);
            }
        });
    }
}
