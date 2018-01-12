package com.example.kevinlay.androidfundamentalspractice.databinding;

import android.databinding.BindingAdapter;
import android.net.Uri;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

/**
 * Created by kevinlay on 1/11/18.
 */

public class MethodHandler {

    public String url = "https://developer.android.com/_static/images/android/touchicon-180.png";

    @BindingAdapter({"bind:imageUri"})
    public static void loadImage(ImageView view, String url) {
        Picasso.with(view.getContext())
                .load(url)
                .fit()
                .centerCrop()
                .into(view);
    }
}
