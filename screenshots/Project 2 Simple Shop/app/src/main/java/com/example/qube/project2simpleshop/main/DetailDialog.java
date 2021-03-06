package com.example.qube.project2simpleshop.main;

import android.content.Context;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.qube.project2simpleshop.R;
import com.example.qube.project2simpleshop.setup.CharacterEsper;
import com.example.qube.project2simpleshop.setup.DB_Helper;

import java.util.ArrayList;

/**
 * Created by Qube on 8/7/16.
 */
public class DetailDialog {
    public TextView mName, mType, mOrigin, mRarity, mPrice, mQuantity, mHP, mMP, mAtk, mDef, mMag, mSpr;
    public ImageView mIcon;

    public void displayDetailDialog(final Context context, final int position, final ArrayList<CharacterEsper> characterEsperArrayList) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        LayoutInflater inflater = LayoutInflater.from(context);
        View dialogLayout = inflater.inflate(R.layout.dialog_detail, null);
        builder.setView(dialogLayout);

        final AlertDialog dialog = builder.create();
        dialog.show();
        ImageButton imageButton = (ImageButton) dialogLayout.findViewById(R.id.button_cancel_dialog);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        Button button = (Button) dialogLayout.findViewById(R.id.button_detail_add_to_cart);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "Good Choice! Added to the cart!", Toast.LENGTH_SHORT).show();
                DB_Helper helper = DB_Helper.getInstance(context);
                //TODO WORK ON HELPER METHOD TO ADD TO CART
                dialog.dismiss();
            }
        });

        mName = (TextView) dialog.findViewById(R.id.tv_detail_name);
        mType = (TextView) dialog.findViewById(R.id.tv_detail_type);
        mOrigin = (TextView) dialog.findViewById(R.id.tv_detail_origin);
        mRarity = (TextView) dialog.findViewById(R.id.tv_detail_rarity);
        mPrice = (TextView) dialog.findViewById(R.id.tv_detail_price);
        mQuantity = (TextView) dialog.findViewById(R.id.tv_detail_quantity);
        mHP = (TextView) dialog.findViewById(R.id.tv_detail_hp);
        mMP = (TextView) dialog.findViewById(R.id.tv_detail_mp);
        mAtk = (TextView) dialog.findViewById(R.id.tv_detail_atk);
        mDef = (TextView) dialog.findViewById(R.id.tv_detail_def);
        mMag = (TextView) dialog.findViewById(R.id.tv_detail_mag);
        mSpr = (TextView) dialog.findViewById(R.id.tv_detail_spr);

        setDetailDialogInfo(characterEsperArrayList.get(position));
    }

    //TODO Figure out what is wrong with this... causing crashes if uncommented
    public void setDetailDialogInfo(CharacterEsper characterEsper) {
        mName.setText(characterEsper.getName());
        mType.setText(characterEsper.getType());
        mOrigin.setText(characterEsper.getOrigin());
        mRarity.setText(characterEsper.getRarity());
//        mPrice.setText(characterEsper.getPrice());
//        mQuantity.setText(characterEsper.getQuantity());
//        mHP.setText(characterEsper.getHp());
//        mMP.setText(characterEsper.getMp());
//        mAtk.setText(characterEsper.getAtk());
//        mDef.setText(characterEsper.getDef());
//        mMag.setText(characterEsper.getMag());
//        mSpr.setText(characterEsper.getSpr());
    }
}
