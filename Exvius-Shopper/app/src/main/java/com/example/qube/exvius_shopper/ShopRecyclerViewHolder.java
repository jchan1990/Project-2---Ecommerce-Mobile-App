package com.example.qube.exvius_shopper;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Qube on 7/30/16.
 */
public class ShopRecyclerViewHolder extends RecyclerView.ViewHolder {

    public ImageView icon;
    public TextView name, type, origin, rarity, price, quantity;
    public CardView card;

    public ShopRecyclerViewHolder(View view) {
        super(view);

        icon = (ImageView) view.findViewById(R.id.icon_imageView);
        name = (TextView) view.findViewById(R.id.name_textView);
        type = (TextView) view.findViewById(R.id.type_textView);
        origin = (TextView) view.findViewById(R.id.origin_textView);
        rarity = (TextView) view.findViewById(R.id.rarity_textView);
        price = (TextView) view.findViewById(R.id.price_textView);
        quantity = (TextView) view.findViewById(R.id.quantity_textView);
    }
}
