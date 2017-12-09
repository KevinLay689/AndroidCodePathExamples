package com.example.kevinlay.androidfundamentalspractice.AdapterViews;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.kevinlay.androidfundamentalspractice.R;

import java.util.ArrayList;

/**
 * Card View Activity
 *
 * Major Takeaways
 * -Very similar to recyclerView, technically uses recyclerView
 *
 * Steps to create a Card View
 *      1. Create XML File
 *      2. Nest a <android.support.v7.widget.CardView> inside a layout
 *      3. Nest a Layout inside the Card View
 *          3a. Create the layout for the Card by adding things to the layout nested inside the Card View
 *      4. Inflate the view later when you create the Recycler View
 */
public class CardViewActivity extends AppCompatActivity {

    private RecyclerView cardViewRecyclerView;
    private ArrayList<UserModel> users = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_view);

        cardViewRecyclerView = (RecyclerView) findViewById(R.id.cardViewRecyclerView);
        populateData();
        UsersCardAdapter adapter = new UsersCardAdapter(users);
        cardViewRecyclerView.setAdapter(adapter);
        cardViewRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void populateData() {
        for(int i = 0; i < 10; i++) {
            UserModel userModel = new UserModel(" User " + i);
            users.add(userModel);
        }
    }
}
