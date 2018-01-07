package com.example.kevinlay.androidfundamentalspractice.DesigningAndStylingViews;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.kevinlay.androidfundamentalspractice.R;

/**
 * Drawable Activity
 *
 * Major Takeaways
 *
 * -Drawables can be applied to any view and are set with background property referencing the drawable resource
 * -StateList: state_enabled controls your default button background, only have a single item with state_enabled
 * -Can make color state selectors
 * -LayerList: nest each new shape in a seperate <item> tag that contains where to draw the shape
 *
 * -Steps to creating a button are complex
 *      1. Create the drawable for the default shape of button
 *      2. Create a stateList to handle all states of button
 *      3. Create a new style in styles.xml thats parent is parent="@android:style/Widget.Button"
 *           3a. Set the background of that parent to the statelist
 *      4. Apply style to the button with @style/
 */

public class DrawableActivity extends AppCompatActivity {

    Button bIncrementButton, bResetButton;

    CustomView customView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawable);

        bIncrementButton = (Button) findViewById(R.id.bIncrementButton);
        bResetButton = (Button) findViewById(R.id.bResetButton);
        customView = (CustomView) findViewById(R.id.customView);

        bIncrementButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                customView.increment();
            }
        });

        bResetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                customView.reset();
            }
        });
    }
}
