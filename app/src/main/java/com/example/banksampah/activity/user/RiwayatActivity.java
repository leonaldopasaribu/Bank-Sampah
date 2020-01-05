package com.example.banksampah.activity.user;

import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.banksampah.R;

import butterknife.BindView;

public class RiwayatActivity extends AppCompatActivity {

    @BindView(R.id.recyclerView_riwayat)
    RecyclerView rvRiwayat;
    @BindView(R.id.riwayat_swiper)
    SwipeRefreshLayout swipeRefreshLayout;
    private RecyclerView.LayoutManager layoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_riwayat);

        rvRiwayat = (RecyclerView) findViewById(R.id.recyclerView_riwayat);

        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this);
        rvRiwayat.setLayoutManager(layoutManager);

    }
}
