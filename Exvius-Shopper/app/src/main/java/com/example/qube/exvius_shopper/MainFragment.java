package com.example.qube.exvius_shopper;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Qube on 7/29/16.
 */
public class MainFragment extends Fragment {

    private TabsPagerAdapter mTabsPagerAdapter;

    private ViewPager mViewPager;
    private TabLayout tabLayout;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        //Get reference to the ViewPager
        mViewPager = (ViewPager) rootView.findViewById(R.id.container);
        //Get reference to the TabLayout
        tabLayout = (TabLayout) rootView.findViewById(R.id.tabLayout_main);

        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mTabsPagerAdapter = new TabsPagerAdapter(getFragmentManager(), 2);
        mViewPager.setAdapter(mTabsPagerAdapter);
        tabLayout.setupWithViewPager(mViewPager);
    }
}
