package com.example.kevinlay.androidfundamentalspractice.AdapterViews;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.kevinlay.androidfundamentalspractice.R;

import java.util.ArrayList;

/**
 * RecyclerView Activity
 *
 * MajorTakeaways
 *
 * -Make changes to direct data source, must modify the existing list
 * -Must notify adapter that element changed, try to notify where on the list it changed, versus calling notifyDataSetChanged()
 * -Better to explicitly say where the set has changed, instead of calling notifyDataSetChanged()
 */

public class RecyclerViewActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<UserModel> users = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        populateData();

        UsersAdapter usersAdapter = new UsersAdapter(users);
        recyclerView.setAdapter(usersAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void populateData() {
        for(int i = 0; i < 10; i++) {
            UserModel userModel = new UserModel("User " + i);
            users.add(userModel);
        }
    }
}
