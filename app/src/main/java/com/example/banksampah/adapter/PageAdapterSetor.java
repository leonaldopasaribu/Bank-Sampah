package com.example.banksampah.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.banksampah.fragment.BerhasilFragmentSetor;
import com.example.banksampah.fragment.DijemputFragmentSetor;
import com.example.banksampah.fragment.MenungguFragmentSetor;
import com.example.banksampah.fragment.SetorFragment;

public class PageAdapterSetor extends FragmentPagerAdapter {
    private int numOfTabs;

    public PageAdapterSetor(FragmentManager fm, int numOfTabs) {
        super(fm);
        this.numOfTabs = numOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new SetorFragment();
            case 1:
                return new MenungguFragmentSetor();
            case 2:
                return new DijemputFragmentSetor();
            case 3:
                return new BerhasilFragmentSetor();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numOfTabs;
    }
}
