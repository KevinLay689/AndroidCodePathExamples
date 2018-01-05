package com.example.kevinlay.androidfundamentalspractice.DataPersistence;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.kevinlay.androidfundamentalspractice.R;

/**
 * Content Provider Activity
 *
 * Content Providers work like this:
 * -ContentResolver communicates with the other apps ContentProvider. ContentProvider receivers data requests
 * from client, then performs the action and returns the result.
 * -Use a CursorLoader to run asynchronous queries in background
 * -The Activity or Fragment in your UI call a CursorLoader to the query, which in turn gets the ContentProvider using the ContentResolver.
 *
 * Example Query
         mCursor = getContentResolver().query(
         UserDictionary.Words.CONTENT_URI,   // The content URI of the words table // FROM
         mProjection,                        // The columns to return for each row // Array
         mSelectionClause                    // Selection criteria // WHERE // Array
         mSelectionArgs,                     // Selection criteria // For adding a ? to SelectionClause and replacing the ?
         mSortOrder);                        // The sort order for the returned rows // ORDER BY
 *
 */

public class ContentProviderActivity extends AppCompatActivity {

    private Button bRetrieveContacts, bCreateContentProvider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_provider);

        bRetrieveContacts = (Button) findViewById(R.id.bRetrieveContacts);
        bRetrieveContacts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        bCreateContentProvider = (Button) findViewById(R.id.bCreateContentProvider);
        bCreateContentProvider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}
