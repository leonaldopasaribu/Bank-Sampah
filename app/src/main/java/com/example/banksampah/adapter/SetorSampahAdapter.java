package com.example.banksampah.adapter;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.banksampah.R;
import com.example.banksampah.model.SetorSampah;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class SetorSampahAdapter extends FirebaseRecyclerAdapter<SetorSampah, SetorSampahAdapter.PastViewHolder> {


    public SetorSampahAdapter(@NonNull FirebaseRecyclerOptions<SetorSampah> options) {
        super(options);
    }


    @Override
    protected void onBindViewHolder(@NonNull PastViewHolder holder, int i, @NonNull SetorSampah setorSampah) {
        holder.jenis.setText(setorSampah.getJenis());
        holder.berat.setText(setorSampah.getBerat());
        holder.date.setText(setorSampah.getDate());
    }

    @NonNull
    @Override
    public PastViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.setor, parent, false);
        return new PastViewHolder(view);
    }

    class PastViewHolder extends RecyclerView.ViewHolder{

        TextView jenis,berat, date;

        public PastViewHolder(@NonNull View itemView) {
            super(itemView);
            jenis = itemView.findViewById(R.id.jenis);
            berat = itemView.findViewById(R.id.berat);
            date = itemView.findViewById(R.id.date);
        }
    }
}