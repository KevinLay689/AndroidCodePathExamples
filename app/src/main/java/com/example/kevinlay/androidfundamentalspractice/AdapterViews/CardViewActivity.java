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
 *
 * -Finish later, very similiar to recyclerview except the single item is a card
 *
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
