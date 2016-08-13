package com.example.qube.project2simpleshop.shoppingcart;

import android.content.DialogInterface;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.qube.project2simpleshop.R;
import com.example.qube.project2simpleshop.setup.DB_Helper;
import com.example.qube.project2simpleshop.setup.ShoppingCartObject;

import java.io.IOException;
import java.util.ArrayList;

public class ShoppingCartActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private RecyclerView rv;
    private LinearLayoutManager llm;
    private DB_Helper helper = DB_Helper.getInstance(this);
    private CardView mCardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_cart);

        ArrayList<ShoppingCartObject> shoppingCartList = helper.getCartItemsAsObjects();
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

        //This should play a sound :D LET'S CROSS OUR FINGERS :D
        chocoboCaller();

        mCardView = (CardView) findViewById(R.id.cv_checkout);
        mCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ShoppingCartActivity.this, "Your followers are waiting for further instructions!", Toast.LENGTH_SHORT).show();

                helper.clearCartTableUponCheckout();
                finish();
            }
        });
    }

    //This should play a sound :D LET'S CROSS OUR FINGERS :D
    public void chocoboCaller() {
        final MediaPlayer mp = new MediaPlayer();
        ImageView imageViewChocobo = (ImageView) findViewById(R.id.iv_chocobo_caller);

        imageViewChocobo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(ShoppingCartActivity.this, "Hmmm... I hear a chocobo nearby", Toast.LENGTH_SHORT).show();
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
