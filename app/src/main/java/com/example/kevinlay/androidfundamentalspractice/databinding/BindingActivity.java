package com.example.kevinlay.androidfundamentalspractice.databinding;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.kevinlay.androidfundamentalspractice.R;

/**
 * Data Binding Activity
 *
 * -If the activity is in a package, the package name must be lowercase in order to target the Binding class
 * otherwise there will be dex errors
 *
 * Steps to using Data Binding
 *      1. Enable Data Binding in app.gradle using
 *          1a. Example: dataBinding {enabled = true}
 *      2. Wrap the layout in a <layout> </layout> tag
 *      3. Include the <data> </data> tag followed by the regular view layout
 *          3a. Add the <variables/> into the <data> </data> tags
 *      4. Inside the Activity target the generated Binding class and use
 *      DataBindingUtil.setContentView(context, layout) to set the view layout
 *          4a. Set the <variables/> objects by creating the object, then using the setName() operator on them
 */

public class BindingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityBindingBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_binding);
        DataBindingUser user = new DataBindingUser();
        binding.setUser(user);

        MethodHandler methodHandler = new MethodHandler();
        binding.setHandler(methodHandler);
    }
}
