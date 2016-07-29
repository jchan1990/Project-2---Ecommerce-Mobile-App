package com.example.qube.exvius_shopper;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Qube on 7/29/16.
 */
public class TabsPagerAdapter extends FragmentPagerAdapter {

    int mPageCount;

    public TabsPagerAdapter(FragmentManager fm, int pageCount) {
        super(fm);
        mPageCount = pageCount;
    }

    @Override
    public Fragment getItem(int position) {
        /*Create instance of the bundle to pass the fragment and
        putting the first key/value as the position of the item since the fragment
         created needs a position*/
        Bundle bundleArgs = new Bundle();
        bundleArgs.putInt(PlaceholderFragment.FRAGMENT_POSITION, position);
        switch (position) {
            default:
            case 0:
                bundleArgs.putInt(PlaceholderFragment.ICON_RES_ID, R.drawable.ic_zidane);
                return PlaceholderFragment.newInstance(bundleArgs);
            case 1:
                bundleArgs.putInt(PlaceholderFragment.ICON_RES_ID, R.drawable.ic_siren);
                return PlaceholderFragment.newInstance(bundleArgs);
        }

    }

    @Override
    public int getCount() {
        return mPageCount;
    }

    public CharSequence getPageTitle(int position) {
        switch (position) {
            default:
            case 0:
                return "CHARACTERS";
            case 1:
                return "ESPERS";
        }
    }
}
