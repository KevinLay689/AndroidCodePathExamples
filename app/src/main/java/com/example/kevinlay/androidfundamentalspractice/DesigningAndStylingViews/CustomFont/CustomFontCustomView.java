package com.example.kevinlay.androidfundamentalspractice.DesigningAndStylingViews.CustomFont;

import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by kevinlay on 1/9/18.
 */

public class CustomFontCustomView extends android.support.v7.widget.AppCompatTextView {
    public CustomFontCustomView(Context context) {
        this(context, null);
    }

    public CustomFontCustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        Typeface typeface = FontUtil.getTypeFace(context, FontUtil.REALITY_SUNDAY);
        setTypeface(typeface);
    }
}
