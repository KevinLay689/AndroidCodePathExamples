package com.example.kevinlay.androidfundamentalspractice.DesigningAndStylingViews.CustomFont;

import android.content.Context;
import android.graphics.Typeface;

import java.util.HashMap;

/**
 * Created by kevinlay on 1/9/18.
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
