package com.example.kevinlay.androidfundamentalspractice.Fragments;

import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;

import com.example.kevinlay.androidfundamentalspractice.Fragments.FlexibleUI.FlexibleUiActivityB;
import com.example.kevinlay.androidfundamentalspractice.Fragments.FlexibleUI.Item;
import com.example.kevinlay.androidfundamentalspractice.Fragments.FlexibleUI.ItemDetailFragment;
import com.example.kevinlay.androidfundamentalspractice.Fragments.FlexibleUI.ItemListFragment;
import com.example.kevinlay.androidfundamentalspractice.R;

/**
 * This class needs work
 *
 */

public class FlexibleUIActivity extends AppCompatActivity implements ItemListFragment.OnListItemSelectedListener{

    private boolean isTwoPane = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flexible_ui);

        determinePaneLayout();
    }

    @Override
    public void onItemSelected(Item item) {

        if (isTwoPane) { // single activity with list and detail
            // Replace framelayout with new detail fragment
            ItemDetailFragment fragmentItem = ItemDetailFragment.newInstance(item);
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.flDetailContainer, fragmentItem);
            ft.commit();
        } else {
            // For phone, launch detail activity using intent
            Intent i = new Intent(this, FlexibleUiActivityB.class);
            // Embed the serialized item
            i.putExtra("item", item);
            // Start the activity
            startActivity(i);
        }
    }

    private void determinePaneLayout() {
        FrameLayout fragmentItemDetail = (FrameLayout) findViewById(R.id.flDetailContainer);
        // If there is a second pane for details
        if (fragmentItemDetail != null) {
            isTwoPane = true;
        }
    }
}
