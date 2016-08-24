package com.example.qube.project2simpleshop.search;

import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.qube.project2simpleshop.R;
import com.example.qube.project2simpleshop.setup.CardViewListener;
import com.example.qube.project2simpleshop.easteregg.ChocoboMediaPlayer;
import com.example.qube.project2simpleshop.main.MainRecyclerViewAdapter;
import com.example.qube.project2simpleshop.setup.DatabaseHelper;

/**
 * Created by Qube on 8/7/16.
 */
public class SearchResultActivity extends AppCompatActivity {
    private RecyclerView rv;
    private LinearLayoutManager llm;
    private RecyclerView.Adapter adapter;
    private View view;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_result);

        rv = (RecyclerView) findViewById(R.id.rv_search);

        Intent.ACTION_SEARCH.equals(getIntent().getAction());
        String query = getIntent().getStringExtra(SearchManager.QUERY);
        adapter = new MainRecyclerViewAdapter(DatabaseHelper.getInstance(this).getCharacterEsperSearch(query));

        llm = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rv.setLayoutManager(llm);

        rv.setAdapter(adapter);
        view = findViewById(R.id.search_result_activity_layout);

        //Calls the method ChocoboCaller in the ChocoboMediaPlayer class to play a sound
        ChocoboMediaPlayer.getInstance(this).ChocoboCaller(this, view);

        //Calls the method CartCardViewListener in the CardViewListener class
        // to listen to a click to bring you to shopping cart
        CardViewListener.getInstance(this).CartCardViewListener(this, view);
    }

}
