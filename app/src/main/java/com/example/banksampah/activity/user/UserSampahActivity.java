package com.example.banksampah.activity.user;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;

import com.example.banksampah.R;
import com.example.banksampah.adapter.SampahAdapter;
import com.example.banksampah.model.JenisSampah;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class UserSampahActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private SampahAdapter adapter;
    Toolbar toolbar;
    Button AddSampah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_sampah);
        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Jenis Sampah");
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
        toolbar.setBackgroundColor(getResources().getColor(R.color.colorPrimary));

        recyclerView = findViewById(R.id.recyclerView_sampah);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<JenisSampah> options =
                new FirebaseRecyclerOptions.Builder<JenisSampah>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("JenisSampah"), JenisSampah.class)
                        .build();

        adapter = new SampahAdapter(options);
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }
}
