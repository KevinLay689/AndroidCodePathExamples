package com.example.kevinlay.androidfundamentalspractice.DesigningAndStylingViews;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.kevinlay.androidfundamentalspractice.R;

/**
 * Styles and Themes Activity
 *
 * Major Takeaways
 *
 * -Defined in styles.xml
 * -Inherit from other styles using parent attribute or use periods like LargeFont.Red.Bold etc
 * -Themes can be applied at application level or activity level
 * -Themes are applied in Manifest
 * -Themes can override default theme items like button text color
 */
public class StylesAndThemesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_styles_and_themes);
    }
}
