package com.example.kevinlay.androidfundamentalspractice.DesigningAndStylingViews.CustomFont;

import android.content.Context;
import android.graphics.Typeface;

import java.util.HashMap;

/**
 * This class serves the purpose of creating a FontUtil class that caches the fonts
 *
 * Steps to creating a FontCache class
 *      1. Create a static Hashmap that is of type String and Typeface
 *      2. Create static Typeface method
 *          2a. The method will either create a new Typeface and add it to the Hashmap, or retrieve a
 *          cached Typeface and return it
 */

public class FontUtil {

    public static final String REALITY_SUNDAY = "Reality-Sunday-light.ttf";
    public static final String SKINNY_THINGS = "Skinny-Things.ttf";
    public static final String SKINNY_THINGS_ITALIC = "Skinny-Things-Italic.ttf";

    private static HashMap<String, Typeface> fontCache = new HashMap<>();

    public static Typeface getTypeFace(Context context, String fontName) {
        Typeface typeface = fontCache.get(fontName);

        if(typeface == null) {

            typeface = Typeface.createFromAsset(context.getAssets(), fontName);
            fontCache.put(fontName, typeface);
        }
        return typeface;
    }
}
