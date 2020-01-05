package com.example.banksampah.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.banksampah.fragment.AdminBerhasilPenarikanFragment;
import com.example.banksampah.fragment.AdminMenungguPenarikanFragment;

public class PageAdapterAdminPenarikan extends FragmentPagerAdapter {
    private int numOfTabs;

    public PageAdapterAdminPenarikan(FragmentManager fm, int numOfTabs) {
        super(fm);
        this.numOfTabs = numOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new AdminMenungguPenarikanFragment();
            case 1:
                return new AdminBerhasilPenarikanFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numOfTabs;
    }
}
