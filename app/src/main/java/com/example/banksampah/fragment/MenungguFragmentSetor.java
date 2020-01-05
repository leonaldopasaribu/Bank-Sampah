package com.example.banksampah.fragment;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.banksampah.R;
import com.example.banksampah.adapter.SetorSampahAdapter;
import com.example.banksampah.model.SetorSampah;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class MenungguFragmentSetor extends Fragment {
    private RecyclerView recyclerView;
    private SetorSampahAdapter adapter;

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

        recyclerView = view.findViewById(R.id.recyclerView_setor);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        FirebaseRecyclerOptions<SetorSampah> options =
                new FirebaseRecyclerOptions.Builder<SetorSampah>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("SetorSampah"), SetorSampah.class)
                        .build();

        adapter = new SetorSampahAdapter(options);
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
