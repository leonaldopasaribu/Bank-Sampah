package com.example.banksampah.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.banksampah.fragment.BerhasilFragmentPenarikan;
import com.example.banksampah.fragment.MenungguFragmentPenarikan;
import com.example.banksampah.fragment.PenarikanFragment;


public class PageAdapterPenarikan extends FragmentPagerAdapter {
    private int numOfTabs;

    public PageAdapterPenarikan(FragmentManager fm, int numOfTabs) {
        super(fm);
        this.numOfTabs = numOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new PenarikanFragment();
            case 1:
                return new MenungguFragmentPenarikan();
            case 2:
                return new BerhasilFragmentPenarikan();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numOfTabs;
    }
}
