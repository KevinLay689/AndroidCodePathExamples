package com.example.kevinlay.androidfundamentalspractice.ViewsAndLayouts;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

import com.example.kevinlay.androidfundamentalspractice.R;

public class TextViewActivity extends AppCompatActivity {

    TextView tvHtmlFormatText, tvCustomFontTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_view);

        tvHtmlFormatText = (TextView) findViewById(R.id.tvHtmlText);
        tvCustomFontTextView = (TextView) findViewById(R.id.tvCustomFontTextView);
        setHtmlFormatText(tvHtmlFormatText);
    }

    private void setCustomFont(TextView textView) {
        /*
            // Get access to our TextView
            TextView txt = (TextView) findViewById(R.id.custom_font);

            // Create the TypeFace from the TTF asset
            Typeface font = Typeface.createFromAsset(getAssets(), "fonts/Chantelli_Antiqua.ttf");
            
            // Assign the typeface to the view
            txt.setTypeface(font);
         */
    }

    private void setHtmlFormatText(TextView textView){
        String formattedText = "This <i>has</i> html <b>formatting</b> of <a href='http://foo.com'>html</a>";
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            textView.setText(Html.fromHtml(formattedText, 0));
        } else{
            textView.setText(Html.fromHtml(formattedText));
        }
    }
}
