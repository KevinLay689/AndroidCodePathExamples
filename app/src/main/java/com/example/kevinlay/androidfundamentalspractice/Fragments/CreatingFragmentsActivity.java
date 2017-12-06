package com.example.kevinlay.androidfundamentalspractice.Fragments;

import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.kevinlay.androidfundamentalspractice.R;

/**
 * Fragment Creating Activity
 *
 * Major Takeaways
 * -If you add fragments dynamically you want to add a "placeholder" container (usually a FrameLayout)
 * to your activity where the fragment is inserted at runtime
 * -Can find fragments by tag once they've been added, won't have id's because they were added at runtime
 * -Activity can invoke fragment methods explicitly, fragment has public methods, activity calls fragment.doSomething()
 * -If fragment needs to communicate with activity it should define a listener interface inner type
 *      -Inside on attach, make sure fragment is passed the context there and check for instance of listener
 * -Add a fragment to backstack with addToBackStack();
 * -Can hide fragments instead of removing
 * -When nesting fragments, use getChildFragmentManager instead of getSupportFragmentManager()
 *
 */

public class CreatingFragmentsActivity extends AppCompatActivity implements FragmentOne.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creating_fragments);

        FragmentOne fragmentOne = new FragmentOne();
        android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        // frag1 is a tag to later find that element
        fragmentTransaction.add(R.id.fragmentOneContainer, fragmentOne, "frag1");
        // Append this transaction to the backstack
        fragmentTransaction.addToBackStack("optional tag");
        fragmentTransaction.commit();

        // Find fragment by Tag
        FragmentOne fragmentOne1 = (FragmentOne) getSupportFragmentManager().findFragmentByTag("frag1");
    }


    @Override
    public void onRssItemSelected(String link) {

    }
}
