package com.example.qube.project2simpleshop.main;

import android.app.SearchManager;
import android.app.SearchableInfo;
import android.content.ComponentName;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.EditText;

import com.example.qube.project2simpleshop.setup.CardViewListener;
import com.example.qube.project2simpleshop.R;
import com.example.qube.project2simpleshop.easteregg.ChocoboMediaPlayer;
import com.example.qube.project2simpleshop.search.SearchResultActivity;
import com.example.qube.project2simpleshop.setup.CharacterEsper;
import com.example.qube.project2simpleshop.setup.DatabaseHelper;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private RecyclerView rv;
    private LinearLayoutManager llm;
    private RecyclerView.Adapter adapter;
    private ArrayList<CharacterEsper> list;
    private DatabaseHelper db;
    private View view;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // RecyclerView set up
        db = DatabaseHelper.getInstance(MainActivity.this);
        list = db.getCharactersAndEspers();
        rv = (RecyclerView) findViewById(R.id.rv_main);
        adapter = new MainRecyclerViewAdapter(list);

        llm = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rv.setLayoutManager(llm);

        rv.setAdapter(adapter);

        // Toolbar set up
        toolbar = (Toolbar) findViewById(R.id.tb_search);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        view = findViewById(R.id.main_activity_layout);

        //Calls the method ChocoboCaller in the ChocoboMediaPlayer class to play a sound
        ChocoboMediaPlayer.getInstance(this).ChocoboCaller(this, view);

        //Calls the method CartCardViewListener in the CardViewListener class
        // to listen to a click to bring you to shopping cart
        CardViewListener.getInstance(this).CartCardViewListener(this, view);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_options_menu, menu);

        //Associate searchable configuration with the SearchView
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView = (SearchView) menu.findItem(R.id.searchOption).getActionView();
        ComponentName componentName = new ComponentName(this, SearchResultActivity.class);
        SearchableInfo searchableInfo = searchManager.getSearchableInfo(componentName);
        searchView.setSearchableInfo(searchableInfo);
        //Changes the color of the text in the SearchView
        EditText searchEditText = (EditText) searchView.findViewById(android.support.v7.appcompat.R.id.search_src_text);
        searchEditText.setTextColor(getResources().getColor(R.color.white));
        searchEditText.setHintTextColor(getResources().getColor(R.color.white));

        return true;
    }
}
