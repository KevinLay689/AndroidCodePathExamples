package com.example.kevinlay.androidfundamentalspractice.Fragments.FlexibleUI;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.kevinlay.androidfundamentalspractice.R;

public class FlexibleUiActivityB extends AppCompatActivity {

    ItemDetailFragment fragmentItemDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flexible_ui_b);

        // Fetch the item to display from bundle
        Item item = (Item) getIntent().getSerializableExtra("item");
        if (savedInstanceState == null) {
            // Insert detail fragment based on the item passed
            fragmentItemDetail = ItemDetailFragment.newInstance(item);
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.flDetailContainer, fragmentItemDetail);
            ft.commit();
        }
    }
}
