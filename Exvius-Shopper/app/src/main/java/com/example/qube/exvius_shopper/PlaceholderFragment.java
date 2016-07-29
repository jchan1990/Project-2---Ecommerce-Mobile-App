package com.example.qube.exvius_shopper;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Qube on 7/29/16.
 */
public class PlaceholderFragment extends Fragment {

    //Constants
    public static final String FRAGMENT_POSITION = "fragment_position";
    public static final String ICON_RES_ID = "icon_src";
    public static final String TEXT_STRING = "text_string";

    //Variables
    private int mFragmentPosition = 0;
    private int mIconResourceId;
    private String mTextString = "";
    private RecyclerView mRecyclerView;

    //Views
    private ImageView imageView;
    private TextView nameText;
    private TextView typeText;
    private TextView originText;
    private TextView rarityText;
    private TextView priceText;
    private TextView quantityText;

    public static Fragment newInstance(@NonNull Bundle bundle) {
        Fragment fragment = new PlaceholderFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view;
        view = inflater.inflate(R.layout.fragment_placeholder, container, false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        switch (mFragmentPosition) {
            default:
            case 0:
//                imageView = (ImageView) view.findViewById(R.id.icon_imageView);
//                imageView.setImageResource(mIconResourceId);
//                nameText = (TextView) view.findViewById(R.id.name_textView);
//                typeText = (TextView) view.findViewById(R.id.type_textView);
//                originText = (TextView) view.findViewById(R.id.origin_textView);
//                rarityText = (TextView) view.findViewById(R.id.rarity_textView);
//                priceText = (TextView) view.findViewById(R.id.price_textView);
//                quantityText = (TextView) view.findViewById(R.id.quantity_textView);
//                return view;

            case 1:
//                imageView = (ImageView) view.findViewById(R.id.icon_imageView);
//                imageView.setImageResource(mIconResourceId);
//                nameText = (TextView) view.findViewById(R.id.name_textView);
//                typeText = (TextView) view.findViewById(R.id.type_textView);
//                originText = (TextView) view.findViewById(R.id.origin_textView);
//                rarityText = (TextView) view.findViewById(R.id.rarity_textView);
//                priceText = (TextView) view.findViewById(R.id.price_textView);
//                quantityText = (TextView) view.findViewById(R.id.quantity_textView);
//                return view;

        }
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //set up the recyclerView
        switch (mFragmentPosition) {
            default:
            case 0:
                imageView.setImageResource(mIconResourceId);
                break;
            case 1:
                imageView.setImageResource(mIconResourceId);
                break;
        }
    }

    @Override
    public void setArguments(Bundle args) {
        super.setArguments(args);

        if (args != null) {
            mFragmentPosition = args.getInt(FRAGMENT_POSITION, 0);
            mIconResourceId = args.getInt(ICON_RES_ID, R.drawable.ic_zidane);
            mTextString = args.getString(TEXT_STRING, "You forgot something");
        }
    }
}
