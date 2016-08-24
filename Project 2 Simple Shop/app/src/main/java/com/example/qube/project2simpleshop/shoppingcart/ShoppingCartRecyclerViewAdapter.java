package com.example.qube.project2simpleshop.shoppingcart;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.qube.project2simpleshop.R;
import com.example.qube.project2simpleshop.setup.DatabaseHelper;
import com.example.qube.project2simpleshop.setup.ShoppingCartObject;

import java.util.ArrayList;

/**
 * Created by Qube on 8/12/16.
 */
public class ShoppingCartRecyclerViewAdapter extends RecyclerView.Adapter<ShoppingCartViewHolder> {
    private ArrayList<ShoppingCartObject> mShoppingCartObjectList = new ArrayList<>();
    private Context mContext;
    DatabaseHelper helper = DatabaseHelper.getInstance(mContext);
    private int mTotal;

    public ShoppingCartRecyclerViewAdapter(Context context, ArrayList<ShoppingCartObject> list) {
        mContext = context;
        mShoppingCartObjectList = list;
    }

    @Override
    public ShoppingCartViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.cardview_shopping_cart, parent, false);
        ShoppingCartViewHolder viewHolder = new ShoppingCartViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ShoppingCartViewHolder holder, int position) {
        final ShoppingCartObject item = mShoppingCartObjectList.get(position);
        holder.mName.setText(item.getmName());
        String shoppingCartPrice = item.getmPrice() + " Gil";
        holder.mPrice.setText(shoppingCartPrice);
        holder.mQuantity.setText(String.valueOf(item.getmQuantity()));
        holder.mIcon.setImageResource(mContext.getResources().getIdentifier(item.getmIcon(), "drawable", mContext.getPackageName()));

        mTotal += helper.getQuantityFromTable(item) * item.getmPrice();

        holder.mRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                removeByPosition(holder.getAdapterPosition());
                Toast.makeText(mContext, item.getmName() + " removed!", Toast.LENGTH_SHORT).show();
            }
        });

        holder.mIncrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mTotal += helper.getQuantityFromTable(item) * item.getmPrice();
                helper.increaseQuantity(item);
                holder.mQuantity.setText(String.valueOf(String.valueOf(helper.getQuantityFromTable(item))));
                holder.mPrice.setText(getNewPrice(item, holder) + " Gil");
            }
        });

        holder.mDecrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                helper.decreaseQuantity(item);
                holder.mQuantity.setText(String.valueOf(helper.getQuantityFromTable(item)));
                holder.mPrice.setText(getNewPrice(item, holder) + " Gil");
            }
        });
    }

    @Override
    public int getItemCount() {
        return mShoppingCartObjectList.size();
    }

    public void removeByPosition(int position) {
        DatabaseHelper.getInstance(mContext).deleteCharacterEsperFromCart(mShoppingCartObjectList.get(position));
        mShoppingCartObjectList.remove(position);
        notifyItemRemoved(position);
    }

    public int getNewPrice(ShoppingCartObject item, ShoppingCartViewHolder holder) {
        int price = item.getmPrice();
        int newPrice;
        int quantity = helper.getQuantityFromTable(item);
        int position = holder.getAdapterPosition();
        if (quantity > 0) {
            if (quantity == 1) {
                return price;
            }
            newPrice = price * quantity;
            newPrice = (int) (Math.floor(newPrice * 100) / 100);
            return newPrice;
        } else {
            removeByPosition(position);
            Toast.makeText(mContext, item.getmName() + " removed!", Toast.LENGTH_SHORT).show();
            return 0;
        }
    }
}
