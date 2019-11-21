package com.example.banksampah.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.banksampah.fragment.BerhasilFragment;
import com.example.banksampah.fragment.DijemputFragment;
import com.example.banksampah.fragment.MenungguFragment;
import com.example.banksampah.fragment.SetorFragment;

public class PageAdapter extends FragmentPagerAdapter {
    private int numOfTabs;

    public PageAdapter(FragmentManager fm, int numOfTabs) {
        super(fm);
        this.numOfTabs = numOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new SetorFragment();
            case 1:
                return new MenungguFragment();
            case 2:
                return new DijemputFragment();
            case 3:
                return new BerhasilFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numOfTabs;
    }
}
