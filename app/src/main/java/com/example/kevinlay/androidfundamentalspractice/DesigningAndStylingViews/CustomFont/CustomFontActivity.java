package com.example.kevinlay.androidfundamentalspractice.DesigningAndStylingViews.CustomFont;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.kevinlay.androidfundamentalspractice.R;

public class CustomFontActivity extends AppCompatActivity {

    private TextView tvCustomFontTextView, tvCustomFontCustomView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_font);

        tvCustomFontTextView = (TextView) findViewById(R.id.tvCustomFontTextView);
        tvCustomFontCustomView = (TextView) findViewById(R.id.tvCustomFontCustomView);


        tvCustomFontTextView.setTypeface(FontUtil.getTypeFace(CustomFontActivity.this, "Reality-Sunday-light.ttf"));

    }
}
