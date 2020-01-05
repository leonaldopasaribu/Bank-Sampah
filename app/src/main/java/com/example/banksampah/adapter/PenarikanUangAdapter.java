package com.example.banksampah.adapter;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.banksampah.R;
import com.example.banksampah.model.PenarikanUang;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class PenarikanUangAdapter extends FirebaseRecyclerAdapter<PenarikanUang, PenarikanUangAdapter.PastViewHolder> {


    public PenarikanUangAdapter(@NonNull FirebaseRecyclerOptions<PenarikanUang> options) {
        super(options);
    }


    @Override
    protected void onBindViewHolder(@NonNull PastViewHolder holder, int i, @NonNull PenarikanUang penarikanUang) {
        holder.jumlah.setText(penarikanUang.getJumlah());
        holder.date.setText(penarikanUang.getDate());
    }

    @NonNull
    @Override
    public PastViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.penarikan, parent, false);
        return new PastViewHolder(view);
    }

    class PastViewHolder extends RecyclerView.ViewHolder{

        TextView jumlah,date;

        public PastViewHolder(@NonNull View itemView) {
            super(itemView);
            jumlah = itemView.findViewById(R.id.jumlah);
            date = itemView.findViewById(R.id.date);
        }
    }
}