package com.example.qube.project2simpleshop.main;

import android.app.SearchManager;
import android.app.SearchableInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.qube.project2simpleshop.R;
import com.example.qube.project2simpleshop.search.SearchResultActivity;
import com.example.qube.project2simpleshop.setup.CharacterEsper;
import com.example.qube.project2simpleshop.setup.DB_Helper;
import com.example.qube.project2simpleshop.shoppingcart.ShoppingCartActivity;

import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private RecyclerView rv;
    private LinearLayoutManager llm;
    private RecyclerView.Adapter adapter;
    private ArrayList<CharacterEsper> list;
    private DB_Helper db;
    private CardView mCardView;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // RecyclerView set up
        db = DB_Helper.getInstance(MainActivity.this);
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

        //This should play a sound :D LET'S CROSS OUR FINGERS :D
        chocoboCaller();

        mCardView = (CardView) findViewById(R.id.cv_main_shopping_cart);
        mCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ShoppingCartActivity.class));
            }
        });
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

    //This should play a sound :D LET'S CROSS OUR FINGERS :D
    public void chocoboCaller() {
        final MediaPlayer mp = new MediaPlayer();
        ImageView imageViewChocobo = (ImageView) findViewById(R.id.iv_chocobo_caller);

        imageViewChocobo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(MainActivity.this, "Hmmm... I hear a chocobo nearby", Toast.LENGTH_SHORT).show();
                if (mp.isPlaying()) {
                    mp.stop();
                }
                try {
                    mp.reset();
                    AssetFileDescriptor afd;
                    afd = getAssets().openFd("ChocoboCall.mp3");
                    mp.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), afd.getLength());
                    mp.prepare();
                    mp.start();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (IllegalStateException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
