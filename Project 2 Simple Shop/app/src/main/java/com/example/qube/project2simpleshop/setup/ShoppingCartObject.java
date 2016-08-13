package com.example.qube.project2simpleshop.setup;

/**
 * Created by Qube on 8/8/16.
 */
public class ShoppingCartObject {
    String mIcon, mName;
    int mPrice, mQuantity;

    public ShoppingCartObject() {
    }

    public ShoppingCartObject(String icon, String name, int price, int quantity) {
        this.mIcon = icon;
        this.mName = name;
        this.mPrice = price;
        this.mQuantity = quantity;
    }

    public String getmIcon() {
        return mIcon;
    }

    public void setmIcon(String mIcon) {
        this.mIcon = mIcon;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public int getmPrice() {
        return mPrice;
    }

    public void setmPrice(int mPrice) {
        this.mPrice = mPrice;
    }

    public int getmQuantity() {
        return mQuantity;
    }

    public void setmQuantity(int mQuantity) {
        this.mQuantity = mQuantity;
    }
}
