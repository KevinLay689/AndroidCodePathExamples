package com.example.kevinlay.androidfundamentalspractice.Fragments;

import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.widget.Toast;

/**
 * Alert Dialog Fragment
 *
 * Major Takeaways
 * -Needs an empty constructor
 * -Uses the newInstance static method just like custom dialog
 * -Uses onCreateDialog to build the fragment instead of inflating a layout, therefor it doesn't need onCreateView
 *
 */

public class MyAlertDialogFragment extends DialogFragment {
    public MyAlertDialogFragment() {

    }

    public static MyAlertDialogFragment newInstance(String title) {
        MyAlertDialogFragment fragment = new MyAlertDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putString("title", title);
        fragment.setArguments(bundle);
        return fragment;
    }


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        String title = getArguments().getString("title", "No title given");

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(title);
        builder.setMessage("Are you sure?");
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getActivity(), "You clicked Ok", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });

        return builder.create();

    }
}
