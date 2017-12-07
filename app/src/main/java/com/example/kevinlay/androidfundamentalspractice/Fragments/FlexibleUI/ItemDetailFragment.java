package com.example.kevinlay.androidfundamentalspractice.Fragments.FlexibleUI;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.kevinlay.androidfundamentalspractice.R;

/**
 * Created by kevinlay on 12/6/17.
 */

public class ItemDetailFragment extends Fragment {

    private Item item;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        item = (Item) getArguments().getSerializable("item");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate view
        View view = inflater.inflate(R.layout.fragment_item_detail, container, false);
        TextView tvTitle = (TextView) view.findViewById(R.id.tvTitle);
        TextView tvBody = (TextView) view.findViewById(R.id.tvBody);
        tvTitle.setText(item.getTitle());
        tvBody.setText(item.getBody());
        // Return view
        return view;
    }

    public static ItemDetailFragment newInstance(Item item) {
        ItemDetailFragment fragmentDemo = new ItemDetailFragment();
        Bundle args = new Bundle();
        args.putSerializable("item", item);
        fragmentDemo.setArguments(args);
        return fragmentDemo;
    }
}
