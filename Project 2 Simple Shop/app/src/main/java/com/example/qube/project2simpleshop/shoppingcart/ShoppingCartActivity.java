package com.example.qube.project2simpleshop.shoppingcart;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.qube.project2simpleshop.setup.CardViewListener;
import com.example.qube.project2simpleshop.R;
import com.example.qube.project2simpleshop.easteregg.ChocoboMediaPlayer;
import com.example.qube.project2simpleshop.setup.DatabaseHelper;
import com.example.qube.project2simpleshop.setup.ShoppingCartObject;

import java.util.ArrayList;

public class ShoppingCartActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private RecyclerView rv;
    private LinearLayoutManager llm;
    private DatabaseHelper helper = DatabaseHelper.getInstance(this);
    private CardView mCardView;
    private View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_cart);

        ArrayList<ShoppingCartObject> shoppingCartList = helper.getCartItemsAsObjects();

        //Checks if shopping cart has any items, if not display a dialog that informs user
        //to add things and brings them back to their last activity
        if (shoppingCartList.size() == 0) {
            AlertDialog.Builder builder = new AlertDialog.Builder(ShoppingCartActivity.this);
            builder.setPositiveButton("Let's find some units", null)
                    .setTitle("Your Cart is Empty!")
                    .setMessage("Why not go to our store and check out some units?");
            final AlertDialog dialog = builder.create();
            dialog.show();
            dialog.getButton(DialogInterface.BUTTON_POSITIVE).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    finish();
                }
            });
        }

        rv = (RecyclerView) findViewById(R.id.rv_shopping_cart);

        llm = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rv.setLayoutManager(llm);
        ShoppingCartRecyclerViewAdapter adapter = new ShoppingCartRecyclerViewAdapter(ShoppingCartActivity.this, shoppingCartList);
        rv.setAdapter(adapter);

        view = findViewById(R.id.shopping_cart_activity_layout);

        //Calls the method ChocoboCaller in the ChocoboMediaPlayer class to play a sound
        ChocoboMediaPlayer.getInstance(this).ChocoboCaller(this, view);
        //Calls the method CheckoutListener in the CardViewListener class to checkout
        CardViewListener.getInstance(this).CheckoutListener(this, view);
    }
}
