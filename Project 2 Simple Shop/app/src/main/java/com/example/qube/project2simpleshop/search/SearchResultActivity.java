package com.example.qube.project2simpleshop.search;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.qube.project2simpleshop.R;
import com.example.qube.project2simpleshop.setup.DB_Helper;

/**
 * Created by Qube on 8/7/16.
 */
public class SearchResultActivity extends AppCompatActivity {
    ListView mListView;

    //TODO Figure out how to finish this activity
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_result);

        mListView = (ListView) findViewById(R.id.lv_search_results);
        if (Intent.ACTION_SEARCH.equals(getIntent().getAction())) {
            String query = getIntent().getStringExtra(SearchManager.QUERY);
            //DB_Helper.getInstance(this).getCharacterEsperSearch(query);

        }
    }
}
