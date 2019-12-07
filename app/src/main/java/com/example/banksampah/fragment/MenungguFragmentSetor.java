package com.example.banksampah.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.banksampah.R;

import butterknife.ButterKnife;


public class MenungguFragmentSetor extends Fragment {
    public MenungguFragmentSetor(){

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_menunggu_setor, container, false);

        ButterKnife.bind(this, view);

        return view;
    }
}
