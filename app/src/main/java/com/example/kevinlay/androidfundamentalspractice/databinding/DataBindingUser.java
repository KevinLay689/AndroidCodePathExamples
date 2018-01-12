package com.example.kevinlay.androidfundamentalspractice.databinding;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.text.Editable;
import android.text.TextWatcher;

import com.android.databinding.library.baseAdapters.BR;

/**
 * Created by kevinlay on 1/11/18.
 */

public class DataBindingUser extends BaseObservable{

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

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }
}
