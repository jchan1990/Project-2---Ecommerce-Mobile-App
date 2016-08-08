package com.example.qube.project2simpleshop.main;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.qube.project2simpleshop.R;

/**
 * Created by Qube on 8/4/16.
 */
public class MainViewHolder extends RecyclerView.ViewHolder {
    public CardView mCardView;
    public ImageView mIcon;
    public TextView mName, mType, mOrigin, mRarity, mPrice, mQuantity;

    public MainViewHolder(View view) {
        super(view);

        mCardView = (CardView) view.findViewById(R.id.cv_main);
        mIcon = (ImageView) view.findViewById(R.id.iv_icon);
        mName = (TextView) view.findViewById(R.id.tv_name);
        mType = (TextView) view.findViewById(R.id.tv_type);
        mOrigin = (TextView) view.findViewById(R.id.tv_origin);
        mRarity = (TextView) view.findViewById(R.id.tv_rarity);
        mPrice = (TextView) view.findViewById(R.id.tv_price);
        mQuantity = (TextView) view.findViewById(R.id.tv_quantity);
    }
}
