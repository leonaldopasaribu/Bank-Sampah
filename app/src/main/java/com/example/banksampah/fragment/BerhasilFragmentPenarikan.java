package com.example.banksampah.fragment;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.banksampah.R;
import com.example.banksampah.adapter.PenarikanUangAdapter;
import com.example.banksampah.model.PenarikanUang;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class BerhasilFragmentPenarikan extends Fragment {
    private RecyclerView recyclerView;
    private PenarikanUangAdapter adapter;

    public BerhasilFragmentPenarikan(){

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_berhasil_penarikan, container, false);

        recyclerView = view.findViewById(R.id.recyclerView_penarikan);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        FirebaseRecyclerOptions<PenarikanUang> options =
                new FirebaseRecyclerOptions.Builder<PenarikanUang>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("PenarikanUang"), PenarikanUang.class)
                        .build();

        adapter = new PenarikanUangAdapter(options);
        recyclerView.setAdapter(adapter);

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    public void onStop() {
        super.onStop();
        adapter.stopListening();
    }
}
