package com.example.kevinlay.androidfundamentalspractice.databinding;

/**
 * Created by kevinlay on 1/11/18.
 */

public class DataBindingUser {

    private final String firstName;
    private final String lastName;

    public DataBindingUser(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }
}
