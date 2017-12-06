package com.example.kevinlay.androidfundamentalspractice.Fragments.FlexibleUI;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kevinlay.androidfundamentalspractice.R;

/**
 * Created by kevinlay on 12/6/17.
 */

public class ItemDetailFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate view
        View view = inflater.inflate(R.layout.fragment_item_detail, container, false);
        // Return view
        return view;
    }
}
