package com.example.kevinlay.androidfundamentalspractice.DesigningAndStylingViews.CustomFont;

import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * This is a Custom View class that extends TextView
 *
 * -Purpose of this class is to extend TextView and provide a way to always have a custom font with the text
 *
 * Steps to creating a Custom View class that extends TextView
 *      1. Subclass the support TextView class
 *      2. Override the constructors
 *          2a. Inside constructors call method to handle applying custom fonts
 *      3. Create Custom font method
 *          3a. Obtain the textStyle passed in by using attrs.getAttributeIntValue(Schema, "textStyle", defaultValue)
 *          3b. The getAttributeIntValue() returns a int that represents the textStyle the user has entered
 *      4. Perform a switch statement on the textStyle to determine which font to apply
 *          4a. Return the correct Typeface Value using the FontUtil caching class
 *      5. Set the typeface
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
        // last parameter is default value
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
