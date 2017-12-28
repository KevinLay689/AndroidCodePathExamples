package com.example.kevinlay.androidfundamentalspractice.Fragments;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Steps to creating a FragmentPagerAdapter
 *      1. Override Constructor
 *      2. Override getItem and perform a switch on the position passed in
 *          2a. In each switch case, return a new instance of the fragment to render
 *      3. Override getCount
 *      4. Optional: Override getPageTitle
 */

public class MyPagerAdapter extends FragmentPagerAdapter {

    private static final int NUM_ITEMS = 3;

    public MyPagerAdapter(FragmentManager fm) {
        super(fm);
    }


    // Main bulk of class, it returns the right fragment
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new FragmentOne();
            case 1:
                return new FragmentTwo();
            case 2:
                return new FragmentThree();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return NUM_ITEMS;
    }

    // Returns the page title for the top indicator
    @Override
    public CharSequence getPageTitle(int position) {
        return "Page " + position;
    }
}
