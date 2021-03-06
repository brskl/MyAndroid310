package com.benjaminsklar.myandroid310;

import android.app.SearchManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class SearchableActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searchable);

        // Get the intent, verify the action and get the query
        Intent intent = getIntent();
        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            String query;
            query = intent.getStringExtra(SearchManager.QUERY);

            //doMySearch(query);
            Toast.makeText(this, "Query:["+query+"]", Toast.LENGTH_LONG).show();
        } else {
            if (Intent.ACTION_VIEW.equals(intent.getAction())) {
                String view;
                view = intent.getDataString();
                Toast.makeText(this, "View:["+view+"]", Toast.LENGTH_LONG).show();
            }
        }
    }
}
