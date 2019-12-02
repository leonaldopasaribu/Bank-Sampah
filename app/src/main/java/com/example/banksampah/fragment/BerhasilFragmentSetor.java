package com.example.banksampah.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.banksampah.R;

import butterknife.ButterKnife;


public class BerhasilFragmentSetor extends Fragment {
    public BerhasilFragmentSetor(){

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_berhasil, container, false);

        ButterKnife.bind(this, view);

        return view;
    }
}
