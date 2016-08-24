package com.example.qube.project2simpleshop.setup;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Toast;

import com.example.qube.project2simpleshop.R;
import com.example.qube.project2simpleshop.main.MainActivity;
import com.example.qube.project2simpleshop.shoppingcart.ShoppingCartActivity;

/**
 * Created by Qube on 8/23/16.
 */
public class CardViewListener {
    private CardView mCardView;
    private DatabaseHelper helper;

    private static CardViewListener instance;

    public CardViewListener(Context applicationContext) {
    }

    // getInstance helper method
    public static CardViewListener getInstance(Context context) {
        if (instance == null) {
            instance = new CardViewListener(context.getApplicationContext());
        }
        return instance;
    }

    // this method should make it listen to a click on the cardview to bring you to shopping cart
    public void CartCardViewListener(final Context context, View view) {
        mCardView = (CardView) view.findViewById(R.id.cv_button_shopping_cart);
        mCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.startActivity(new Intent(context, ShoppingCartActivity.class));
            }
        });
    }

    // this method should make it listen to a click in the cardview to checkout the shopping cart
    public void CheckoutListener(final Context context, View view) {
        helper = DatabaseHelper.getInstance(context);
        mCardView = (CardView) view.findViewById(R.id.cv_checkout);
        mCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "Your followers are waiting for further instructions!", Toast.LENGTH_SHORT).show();

                helper.clearCartTableUponCheckout();
                context.startActivity(new Intent(context, MainActivity.class));
            }
        });
    }
}
