package com.example.qube.project2simpleshop.shoppingcart;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.qube.project2simpleshop.R;

/**
 * Created by Qube on 8/12/16.
 */
public class ShoppingCartViewHolder extends RecyclerView.ViewHolder {
    public CardView mCardView;
    public ImageView mIcon;
    public TextView mName, mPrice, mQuantity, mTotal;
    public ImageButton mDecrement, mIncrement, mRemove;

    public ShoppingCartViewHolder(View view) {
        super(view);

//        mTotal = (TextView) view.findViewById(R.id.tv_total);
        mCardView = (CardView) view.findViewById(R.id.cv_shopping_cart);
        mIcon = (ImageView) view.findViewById(R.id.iv_icon_cart);
        mName = (TextView) view.findViewById(R.id.tv_name_cart);
        mPrice = (TextView) view.findViewById(R.id.tv_price_cart);
        mQuantity = (TextView) view.findViewById(R.id.tv_quantity_cart);
        mDecrement = (ImageButton) view.findViewById(R.id.ib_decrement_cart);
        mIncrement = (ImageButton) view.findViewById(R.id.ib_increment_cart);
        mRemove = (ImageButton) view.findViewById(R.id.ib_remove_cart);
    }
}
