package com.example.kevinlay.androidfundamentalspractice.databinding;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;
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
 *      3. Inside the setter, use notifyPropertyChanged(BR.name) to update the view
 *
 * Steps for using Method References for onClick
 *      1. Create the onClick method in one of the variables passed to the layout
 *      2. In XML, set the onClick attribute to @{variableName::onClickMethod}
 *          2a. Example android:onClick="@{user::clickForNameToast}"
 *      3. Use this over Listener Bindings when you want the method to be generated when the
 *      actual listener implementation is created when the data is bound.
 *          3a. If you prefer to evaluate the expression when the event happens, you should use listener binding
 *
 * Steps for using Listener Bindings for onClick
 *      1. Create the onClick method in one of the variables passed to the layout
 *      2. In XML, set the onClick attibute using a lambda expression
 *          2a. Example android:onClick="@{() -> presenter.onSaveClick(task)}"
 *      3. Variables can be passed in as parameters for the method
 *          3a. Example android:onClick="@{(view) -> presenter.onSaveClick(view, user)}"
 *          3b.  Listener bindings provide two choices for listener parameters: you can either ignore
 *          all parameters to the method or name all of them
 *      4. Use this when the method definition may not match the event method, an exmaple is
 *      android:onClick="@{(view) -> presenter.onSaveClick(view, user)}" the onSaveClick will not just use a method
 *      with the view parameter, but it also wants a user paramater that can be passed in as a variable
 *
 * Steps for using a Ternary Operator inside XML
 *      1. Inside a @{} tag, use the ternary operator with easy to read logic
 *          1a. Example user.isUser ? user.registerYes : user.registerNo
 *      2. Use easy to read logic, it is impossible to test this logic
 *
 */

public class DataBindingUser extends BaseObservable {

    public String url = "https://developer.android.com/_static/images/android/touchicon-180.png";
    public String registerYes = "Yes Register";
    public String registerNo = "No Register";

    private String firstName = "";
    private String lastName = "";
    private boolean isUser = true;

    public final ObservableField<String> age = new ObservableField<>();

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

    public final TextWatcher ageChanged = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void afterTextChanged(Editable editable) {
            age.set(editable.toString());
        }
    };

    public void clickForNameToast(View view) {
        Toast.makeText(view.getContext(), "Full name is: " + firstName + " " + lastName, Toast.LENGTH_SHORT ).show();
    }

    public void clickForNameToastListenerBinding(View view, DataBindingUser user) {
        Toast.makeText(view.getContext(), "Full name is: " + user.firstName + " " + user.lastName, Toast.LENGTH_SHORT ).show();
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public boolean isUser() {
        return isUser;
    }
}
