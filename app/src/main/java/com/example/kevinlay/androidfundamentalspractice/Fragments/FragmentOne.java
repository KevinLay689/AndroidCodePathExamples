package com.example.kevinlay.androidfundamentalspractice.Fragments;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kevinlay.androidfundamentalspractice.R;

/**
 * This Fragment shows how to use a callback within a fragment
 *
 * Major Takeaways
 *
 * Steps to using callback within fragment
 *
 *      1. Use a interface inner class within the fragment
 *      2. Create a instance of this interface as a private field
 *      3. Inside onAttach, cast the interface into an object using the context passed in
 *      4. Throw an class exception if the interface is not found
 *      5. Make the calling activity implement this interface
 *      6. Handle callback in activity
 */

public class FragmentOne extends android.support.v4.app.Fragment {

    private OnItemSelectedListener listener;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_one_layout, container, false);
    }

    // This event is triggered soon after onCreateView().
    // Any view setup should occur here.  E.g., view lookups and attaching view listeners.
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    public interface OnItemSelectedListener {
        // This can be any number of events to be sent to the activity
        public void onRssItemSelected(String link);
    }

    // Store the listener (activity) that will have events fired once the fragment is attached
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnItemSelectedListener) {
            listener = (OnItemSelectedListener) context;
        } else {
            throw new ClassCastException(context.toString()
                    + " must implement MyListFragment.OnItemSelectedListener");
        }
    }

}
