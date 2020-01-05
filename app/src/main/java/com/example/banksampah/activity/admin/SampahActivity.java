package com.example.banksampah.activity.admin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.banksampah.R;
import com.example.banksampah.adapter.SampahAdapter;
import com.example.banksampah.model.JenisSampah;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class SampahActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private SampahAdapter adapter;
    Toolbar toolbar;
    Button AddSampah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sampah);
        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Jenis Sampah");
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
        toolbar.setBackgroundColor(getResources().getColor(R.color.colorPrimary));

        AddSampah = (Button) findViewById(R.id.btnAddSampah);

        AddSampah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Opening new user registration activity using intent on button click.
                Intent intent = new Intent(SampahActivity.this, AddSampahActivity.class);
                startActivity(intent);

            }
        });

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
