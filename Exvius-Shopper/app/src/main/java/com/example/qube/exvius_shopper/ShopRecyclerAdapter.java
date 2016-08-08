package com.example.qube.exvius_shopper;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by Qube on 7/30/16.
 */
public class ShopRecyclerAdapter extends RecyclerView.Adapter<ShopRecyclerViewHolder> {

    private ArrayList<CharacterEsper> characterEspers;
    private Context context;

    private ShopItemClickListener listener;

    public interface ShopItemClickListener {
        void onShopItemClicked(View view, String characterEsperName);
    }

    public void setShopItemClickListener(ShopItemClickListener itemClickListener) {
        this.listener = itemClickListener;
    }

    public ShopRecyclerAdapter(ArrayList<CharacterEsper> list) {
        characterEspers = list;
    }

    @Override
    public ShopRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.item_character_esper, parent, false);
        ShopRecyclerViewHolder holder = new ShopRecyclerViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ShopRecyclerViewHolder holder, int position) {
        final CharacterEsper characterEsper = characterEspers.get(position);
        holder.name.setText(characterEsper.getName());
        holder.type.setText(characterEsper.getType());
        String ffOrigin = "(" + characterEsper.getOrigin() + ")";
        holder.origin.setText(ffOrigin);
        String gilPrice = characterEsper.getPrice() + " Gil";
        holder.price.setText(gilPrice);
        holder.icon.setImageResource(context.getResources().getIdentifier(characterEsper.getIcon(), "drawable", context.getPackageName()));

        View.OnClickListener clickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onShopItemClicked(view, characterEsper.getName());
            }
        };
        holder.card.setOnClickListener(clickListener);
    }

    @Override
    public int getItemCount() {
        return characterEspers.size();
    }

    //TODO Just incase
    public void updateList(){
    }
}
