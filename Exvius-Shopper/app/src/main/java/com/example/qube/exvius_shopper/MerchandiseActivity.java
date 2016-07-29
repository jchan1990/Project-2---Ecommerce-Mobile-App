package com.example.qube.exvius_shopper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MerchandiseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_merchandise);

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.main_content_container, new MainFragment())
                .commit();
    }
}
