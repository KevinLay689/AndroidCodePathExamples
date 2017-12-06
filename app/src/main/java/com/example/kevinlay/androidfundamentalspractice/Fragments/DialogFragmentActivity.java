package com.example.kevinlay.androidfundamentalspractice.Fragments;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.kevinlay.androidfundamentalspractice.R;

public class DialogFragmentActivity extends AppCompatActivity {

    private Button bShowCustomDialogFragment, bShowAlertDialogFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog_fragment);

        bShowCustomDialogFragment = (Button) findViewById(R.id.bShowCustomDialogFragment);
        bShowAlertDialogFragment = (Button) findViewById(R.id.bShowAlertDialogFragment);

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

    }


    private void showCustomDialog() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        MyCustomDialogFragment fragment = MyCustomDialogFragment.newInstance("This is my custom fragment");
        fragment.show(fragmentManager, "customDialogTag");
    }

    private void showAlertDialog() {

    }

}
