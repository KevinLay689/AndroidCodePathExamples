package com.example.kevinlay.androidfundamentalspractice.DesigningAndStylingViews.CustomFont;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.kevinlay.androidfundamentalspractice.R;

/**
 * This is the Custom Font Activity
 *
 * 2 Major ways to achieve custom fonts
 *      1. Quick and dirty way is to get a reference to the view, then apply the custom font to it
 *      using the FontUtil caching class
 *      2. Second and better way is to subclass TextView and set the Typeface for the whole view
 *      inside the constructor
 */

public class CustomFontActivity extends AppCompatActivity {

    private TextView tvCustomFontTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_font);

        tvCustomFontTextView = (TextView) findViewById(R.id.tvCustomFontTextView);
        tvCustomFontTextView.setTypeface(FontUtil.getTypeFace(CustomFontActivity.this, FontUtil.REALITY_SUNDAY));
    }
}
