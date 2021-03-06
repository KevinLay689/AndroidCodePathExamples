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
 * -See android documentation for more info: https://developer.android.com/topic/libraries/data-binding/index.html
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
 *
 * Steps to passing variables inside a <include> </include> tag
 *      1. Add a bind namespace to the layout
 *      2. Pass the variable name inside using the bind namespace
 *          2a. Example bind:user2="@{user}"
 *      3. Create the variable inside the other layout file, this variable name must match the bind variable
 *          3a. Example <variable name="user2" type="com.example.kevinlay.androidfundamentalspractice.databinding.DataBindingUser"/>
 *      4. Reference the user object inside the other layout
 *
 * Steps to using imports with Data Binding
 *      1. Add the <import/> tag to the data section
 *      2. Make the type of the import the entire class name that is being imported
 *          2a. Example <import type="android.view.View"/>
 *          2b. Can also give the class a alias type so it can be referenced as that alias instead of its classname
 *      3. Use the import type in XML
 *          3a. Example android:visibility="@{user.isAdult ? View.VISIBLE : View.GONE}"
 *
 * Steps to using Observable Fields
 *      1. Create a public final ObservableField
 *          1a. Example public final ObservableField<String> age = new ObservableField<>();
 *      2. Change its values with set()
 *      3. Retrieve its value with get()
 *      4. The field will automatically update itself, basically get 2 way binding for free by using these
 *
 * To use BindingAdapters see: CustomBinders.java
 * To use 2 way binding with BaseObservable see: DataBindingUser.java
 * To use Method References see: DataBindingUser.java
 */

public class BindingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityBindingBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_binding);
        DataBindingUser user = new DataBindingUser();
        binding.setUser(user);
    }
}
