package com.example.qube.exvius_shopper;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by Qube on 7/30/16.
 */
public class ShopFragment extends Fragment {

    private RecyclerView recyclerView;
    private ShopRecyclerAdapter adapter;

    private ShopRecyclerAdapter.ShopItemClickListener listener;

    public static Fragment getInstance(ShopRecyclerAdapter.ShopItemClickListener listen) {
        ShopFragment fragment = new ShopFragment();
        fragment.listener = listen;
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_placeholder, container, false);

        recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView);

        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }


}
