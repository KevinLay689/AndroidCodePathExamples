package com.example.kevinlay.androidfundamentalspractice.Fragments;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.kevinlay.androidfundamentalspractice.R;

public class DialogFragmentActivity extends AppCompatActivity implements  MyAlertDialogFragment.AlertListener{

    private Button bShowCustomDialogFragment, bShowAlertDialogFragment, bShowReturnedDialogValue;
    private String value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog_fragment);

        bShowCustomDialogFragment = (Button) findViewById(R.id.bShowCustomDialogFragment);
        bShowAlertDialogFragment = (Button) findViewById(R.id.bShowAlertDialogFragment);
        bShowReturnedDialogValue = (Button) findViewById(R.id.bShowReturnedDialogValue);

        bShowCustomDialogFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showCustomDialog();
            }
        });

        bShowAlertDialogFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showAlertDialog();
            }
        });

        bShowReturnedDialogValue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showReturnedValue();
            }
        });

    }

    private void showReturnedValue() {

    }

    /**
     * Steps to creating a Dialog Fragment
     */

    private void showCustomDialog() {
        // 1. Get the Fragment Manager
        FragmentManager fragmentManager = getSupportFragmentManager();
        // 2. Create the instance of the fragment
        MyCustomDialogFragment fragment = MyCustomDialogFragment.newInstance("This is my custom fragment");
        // 3. Show the fragment using fragment.show and pass it the fragment manager and tag
        fragment.show(fragmentManager, "customDialogTag");
    }

    private void showAlertDialog() {
        android.app.FragmentManager fm = getFragmentManager();
        MyAlertDialogFragment fragment = MyAlertDialogFragment.newInstance("This is an alert dialog");
        fragment.show(fm,"");
    }

    @Override
    public void updateData(String input) {
        Toast.makeText(this, input , Toast.LENGTH_SHORT).show();
    }
}
