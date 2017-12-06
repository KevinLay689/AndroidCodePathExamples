package com.example.kevinlay.androidfundamentalspractice.Fragments;

import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
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
 * -Pass data back to activity with listeners interface, same as fragment, handle check for listener implementation in onAttach
 * -Pass data back to fragment, see below code sendBackResult()
 */

public class MyAlertDialogFragment extends DialogFragment {

    AlertListener alertListener;

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
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof AlertListener) {
            alertListener = (AlertListener) context;
        } else {
            throw new ClassCastException(context.toString()
                    + " must implement MyListFragment.OnItemSelectedListener");
        }
    }

    public interface AlertListener{
        void updateData(String input);
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
                //Toast.makeText(getActivity(), "You clicked Ok", Toast.LENGTH_SHORT).show();
                alertListener.updateData("You clicked Ok");
                //sendBackResult();
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

    //This is for passing data back to fragment
    //Inside parent fragment, must call setTargetFragment(MyParentFragment.this, 300);
    //Must call it before calling the show() command
    public void sendBackResult() {
        // Notice the use of `getTargetFragment` which will be set when the dialog is displayed
        AlertListener listener = (AlertListener) getTargetFragment();
        listener.updateData("Data from inside MyAlertDialogFragment");
        dismiss();
    }

}
