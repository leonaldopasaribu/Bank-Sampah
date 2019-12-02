package com.example.banksampah.activity;

import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.TabItem;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.example.banksampah.R;
import com.example.banksampah.adapter.PageAdapterSetor;

public class SetorActivity extends AppCompatActivity {
    Toolbar toolbar;
    TabLayout tabLayout;
    ViewPager viewPager;
    PageAdapterSetor pageAdapter;
    TabItem tabSetor;
    TabItem tabMenunggu;
    TabItem tabDijemput;
    TabItem tabBerhasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setor);

        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Setor Sampah");
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
        toolbar.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        setSupportActionBar(toolbar);

        tabLayout = findViewById(R.id.tabLayout);
        tabSetor = findViewById(R.id.tabSetor);
        tabMenunggu = findViewById(R.id.tabMenunggu);
        tabDijemput = findViewById(R.id.tabDijemput);
        tabBerhasil = findViewById(R.id.tabBerhasil);
        viewPager = findViewById(R.id.viewPager);

        pageAdapter = new PageAdapterSetor(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(pageAdapter);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                if (tab.getPosition() == 1) {
                    toolbar.setBackgroundColor(ContextCompat.getColor(SetorActivity.this,
                            R.color.menunggu));
                    tabLayout.setBackgroundColor(ContextCompat.getColor(SetorActivity.this,
                            R.color.menunggu));
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        getWindow().setStatusBarColor(ContextCompat.getColor(SetorActivity.this,
                                R.color.menunggu));
                    }
                } else if (tab.getPosition() == 2) {
                    toolbar.setBackgroundColor(ContextCompat.getColor(SetorActivity.this,
                            R.color.dijemput));
                    tabLayout.setBackgroundColor(ContextCompat.getColor(SetorActivity.this,
                            R.color.dijemput));
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        getWindow().setStatusBarColor(ContextCompat.getColor(SetorActivity.this,
                                R.color.dijemput));
                    }
                } else if (tab.getPosition() == 3) {
                    toolbar.setBackgroundColor(ContextCompat.getColor(SetorActivity.this,
                            R.color.berhasil));
                    tabLayout.setBackgroundColor(ContextCompat.getColor(SetorActivity.this,
                            R.color.berhasil));
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        getWindow().setStatusBarColor(ContextCompat.getColor(SetorActivity.this,
                                R.color.berhasil));
                    }
                } else {
                    toolbar.setBackgroundColor(ContextCompat.getColor(SetorActivity.this,
                            R.color.colorPrimary));
                    tabLayout.setBackgroundColor(ContextCompat.getColor(SetorActivity.this,
                            R.color.colorPrimary));
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        getWindow().setStatusBarColor(ContextCompat.getColor(SetorActivity.this,
                                R.color.colorPrimary));
                    }
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

    }
}
