package com.example.kevinlay.androidfundamentalspractice.ViewsAndLayouts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.kevinlay.androidfundamentalspractice.R;

/**
 * Input Views Activity
 *
 * Major Takeaways:
 * -2 steps to onCheckChangedListeners: 1st Create compoundButton onCheckChanged Listener anonymous class.
 * 2nd Set checkboxes onCheckChangedListeners to it
 * -RadioButtons must be grouped in a radio group
 * -Set their onclick to a method and handle it at runtime
 * -Must cast the view on onclicked to get if it is checked or not
 * -Spinner shoudl use a array to hold inputs, referenced with @array/***
 */

public class InputViewActivity extends AppCompatActivity {

    CheckBox cbMeat, cbCheese;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_view);

        cbMeat = (CheckBox) findViewById(R.id.cbMeat);
        cbCheese = (CheckBox) findViewById(R.id.cbCheese);

        //Grab if checkbox is checked
        Boolean isMeatChecked = cbMeat.isChecked();

        //Listeners for this

        CompoundButton.OnCheckedChangeListener checkListener = new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                switch (compoundButton.getId()) {
                    case R.id.cbMeat :{
                        if(isChecked) {
                            Toast.makeText(getApplicationContext(), "Meat Checked", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    }
                    case R.id.cbCheese :{
                        if(isChecked) {
                            Toast.makeText(getApplicationContext(), "Cheese Checked", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    }
                }
            }
        };

        cbMeat.setOnCheckedChangeListener(checkListener);
        cbCheese.setOnCheckedChangeListener(checkListener);

    }

    public void onRadioButtonClicked(View view) {

        Boolean isChecked = ((RadioButton) view).isChecked();

        switch(view.getId()) {
            case R.id.rbPirate: {
                if(isChecked) {
                    Toast.makeText(getApplicationContext(), "Pirate Checked", Toast.LENGTH_SHORT).show();
                }
                break;
            }
            case R.id.rbNinja: {
                if(isChecked) {
                    Toast.makeText(getApplicationContext(), "Ninja Checked", Toast.LENGTH_SHORT).show();
                }
                break;
            }
        }
    }
}
