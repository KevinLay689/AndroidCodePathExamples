package com.example.kevinlay.androidfundamentalspractice.databinding;

import android.databinding.BindingAdapter;
import android.net.Uri;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

/**
 * Steps to creating a Binding Adapter
 *      1. Annotate the method with @BindingAdapter
 *      2. Create a static method that can be referenced in the XML
 *      3. Inside the XML, add a namespace for bind:
 *          3a. Example xmlns:bind="http://schemas.android.com/apk/res-auto"
 *      4. Reference the BindingAdapter class and set it equal to the value of your parameter
 *          4a. Example bind:imageUri="@{user.url}"
 */

public class CustomBinders {

    @BindingAdapter({"bind:imageUri"})
    public static void loadImage(ImageView view, String url) {
        Picasso.with(view.getContext())
                .load(url)
                .fit()
                .centerCrop()
                .into(view);
    }
}
