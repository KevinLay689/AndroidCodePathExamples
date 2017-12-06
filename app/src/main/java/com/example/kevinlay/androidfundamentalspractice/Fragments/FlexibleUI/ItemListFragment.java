package com.example.kevinlay.androidfundamentalspractice.Fragments.FlexibleUI;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.kevinlay.androidfundamentalspractice.R;

import java.util.ArrayList;

/**
 * Created by kevinlay on 12/6/17.
 */

public class ItemListFragment extends Fragment {
    private ArrayAdapter<Item> adapterItems;
    private ListView lvItems;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Create arraylist from item fixtures
        ArrayList<Item> items = Item.getItems();
        // Create adapter based on items
        adapterItems = new ArrayAdapter<Item>(getActivity(), android.R.layout.simple_list_item_activated_1, items);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate view
        View view = inflater.inflate(R.layout.fragment_item_list,
                container, false);
        // Attach adapter to listview
        lvItems = (ListView) view.findViewById(R.id.lvItems);
        lvItems.setAdapter(adapterItems);
        // Return view
        return view;
    }
}