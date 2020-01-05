package com.example.banksampah.adapter;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.banksampah.R;
import com.example.banksampah.model.JenisSampah;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class SampahAdapter extends FirebaseRecyclerAdapter<JenisSampah, SampahAdapter.PastViewHolder> {


    public SampahAdapter(@NonNull FirebaseRecyclerOptions<JenisSampah> options) {
        super(options);
    }


    @Override
    protected void onBindViewHolder(@NonNull PastViewHolder holder, int i, @NonNull JenisSampah jenisSampah) {
        holder.image.setText(jenisSampah.getImage());
        holder.jenis.setText(jenisSampah.getJenis());
    }

    @NonNull
    @Override
    public PastViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.sampah, parent, false);
        return new PastViewHolder(view);
    }

    class PastViewHolder extends RecyclerView.ViewHolder{

        TextView image,jenis;

        public PastViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            jenis = itemView.findViewById(R.id.jenis);
        }
    }
}