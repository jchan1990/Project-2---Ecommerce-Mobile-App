package com.example.qube.project2simpleshop.main;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.qube.project2simpleshop.R;
import com.example.qube.project2simpleshop.setup.CharacterEsper;

import java.util.ArrayList;

/**
 * Created by Qube on 8/5/16.
 */
public class MainRecyclerViewAdapter extends RecyclerView.Adapter<MainViewHolder> {
    private ArrayList<CharacterEsper> mCharacterEsperList = new ArrayList<>();
    private Context mContext;

    public MainRecyclerViewAdapter(final ArrayList<CharacterEsper> list) {
        mCharacterEsperList = list;
    }

    @Override
    public MainViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        View view = LayoutInflater.from(mContext).inflate(R.layout.cardview_main, parent, false);
        MainViewHolder viewHolder = new MainViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MainViewHolder holder, final int position) {
        final CharacterEsper characterEsper = mCharacterEsperList.get(position);
        holder.mName.setText(characterEsper.getName());
        holder.mType.setText(characterEsper.getType());
        String characterEsperOrigin = "(" + characterEsper.getOrigin() + ")";
        holder.mOrigin.setText(characterEsperOrigin);
        holder.mRarity.setText(characterEsper.getRarity());
        String characterEsperPrice = characterEsper.getPrice() + " Gil";
        holder.mPrice.setText(characterEsperPrice);
        String characterEsperQuantity = "In Stock";
        holder.mQuantity.setText(characterEsperQuantity);
        holder.mIcon.setImageResource(mContext.getResources().getIdentifier(characterEsper.getIcon(), "drawable", mContext.getPackageName()));

        holder.mCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DetailDialog detailDialog = new DetailDialog();
                detailDialog.displayDetailDialog(view.getContext(), position, mCharacterEsperList);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mCharacterEsperList.size();
    }
}
