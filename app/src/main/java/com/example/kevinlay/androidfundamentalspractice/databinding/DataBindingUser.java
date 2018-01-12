package com.example.kevinlay.androidfundamentalspractice.databinding;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Toast;

import com.android.databinding.library.baseAdapters.BR;

/**
 * This class is for 2 way binding
 *
 * -Extending BaseObservable allows the user to use things like notifyPropertyChanged() to mark the view
 * as dirty to be updated.
 *
 * Steps to using 2 way binding with BaseObservable.
 *      1. In your model extend the BaseObservable class
 *      2. Annotate the getter of your data property
 *          2a. This will generate a BR class file in the module package
 *          2b. This BR class file can be referenced later in order to notify the view has changed
 *      3. Inside the setter, use notifyPropertyChanged(BR.name) to update the view.
 */

public class DataBindingUser extends BaseObservable {

    public String url = "https://developer.android.com/_static/images/android/touchicon-180.png";

    private String firstName = "";
    private String lastName = "";

    @Bindable
    public String getFormattedName() {
        return firstName + " " + lastName;
    }

    public DataBindingUser() {

    }

    public final TextWatcher firstNameChanged = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void afterTextChanged(Editable editable) {
            firstName = editable.toString();
            notifyPropertyChanged(BR.formattedName);
        }
    };

    public final TextWatcher lastNameChanged = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void afterTextChanged(Editable editable) {
            lastName = editable.toString();
            notifyPropertyChanged(BR.formattedName);
        }
    };

    public void clickForNameToast(View view) {
        Toast.makeText(view.getContext(), "Full name is: " + firstName + " " + lastName, Toast.LENGTH_SHORT ).show();
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }
}
