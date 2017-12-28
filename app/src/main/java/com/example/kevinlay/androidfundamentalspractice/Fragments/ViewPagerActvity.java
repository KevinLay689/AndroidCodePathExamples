package com.example.kevinlay.androidfundamentalspractice.Fragments;

import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.kevinlay.androidfundamentalspractice.R;

/**
 * View Pager Activity
 *
 * Major Takeaways
 * -If you want the strip at the top near the tabs that indicates what tab you're on, must nest a PagerTabStrip inside the viewpager
 * -Needs a adapter to determine how many pages exist and what fragment to display at those pages
 * -Adapter needs to use supportFragmentManager, therefore the fragments must subclass the right fragment support class
 * -Override getItem and return the new instances of the fragments
 *
 * Steps to creating a View Pager
 *      1. Add the View Pager to XML
 *      2. Target the ViewPager by id
 *      3. Create the Custom Adapter and pass it the fragmentManager
 *      4. Set the Viewpager Adapter to the Custom Adapter
 *
 *
 */
public class ViewPagerActvity extends AppCompatActivity implements FragmentOne.OnItemSelectedListener{

    FragmentPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager_actvity);
        ViewPager viewPager = (ViewPager) findViewById(R.id.vpPager);
        adapter = new MyPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
    }

    @Override
    public void onRssItemSelected(String link) {

    }
}
