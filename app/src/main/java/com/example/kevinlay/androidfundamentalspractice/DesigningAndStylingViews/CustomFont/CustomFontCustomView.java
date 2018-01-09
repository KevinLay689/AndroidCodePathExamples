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

    public static final String ANDROID_SCHEMA = "http://schemas.android.com/apk/res/android";

    public CustomFontCustomView(Context context) {
        this(context, null);
    }

    public CustomFontCustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        applyCustomFont(context, attrs);
    }

    private void applyCustomFont(Context context, AttributeSet attrs) {
        int textStyle = attrs.getAttributeIntValue(ANDROID_SCHEMA, "textStyle", Typeface.NORMAL);

        Typeface customFont = selectTypeface(context, textStyle);
        setTypeface(customFont);
    }

    private Typeface selectTypeface(Context context, int textStyle) {

        switch (textStyle) {
            case Typeface.BOLD: // bold
                return FontUtil.getTypeFace(context, FontUtil.SKINNY_THINGS);

            case Typeface.ITALIC: // italic
                return FontUtil.getTypeFace(context, FontUtil.SKINNY_THINGS_ITALIC);

            case Typeface.BOLD_ITALIC: // bold italic
                return FontUtil.getTypeFace(context, FontUtil.SKINNY_THINGS_ITALIC);

            case Typeface.NORMAL: // regular
            default:
                return FontUtil.getTypeFace(context, FontUtil.SKINNY_THINGS);
        }
    }
}
