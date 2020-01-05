package com.example.banksampah.activity.user;

import android.os.Build;
import android.os.Bundle;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.banksampah.R;
import com.example.banksampah.adapter.PageAdapterPenarikan;

public class PenarikanActivity extends AppCompatActivity {
    Toolbar toolbar;
    TabLayout tabLayout;
    ViewPager viewPager;
    PageAdapterPenarikan pageAdapter;
    TabItem tabPenarikan;
    TabItem tabMenunggu;
    TabItem tabBerhasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_penarikan);

        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Penarikan Uang");
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
        toolbar.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        setSupportActionBar(toolbar);

        tabLayout = findViewById(R.id.tabLayout);
        tabPenarikan = findViewById(R.id.tabPenarikan);
        tabMenunggu = findViewById(R.id.tabMenunggu);
        tabBerhasil = findViewById(R.id.tabBerhasil);
        viewPager = findViewById(R.id.viewPager);

        pageAdapter = new PageAdapterPenarikan(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(pageAdapter);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                if (tab.getPosition() == 1) {
                    toolbar.setBackgroundColor(ContextCompat.getColor(PenarikanActivity.this,
                            R.color.menunggu));
                    tabLayout.setBackgroundColor(ContextCompat.getColor(PenarikanActivity.this,
                            R.color.menunggu));
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        getWindow().setStatusBarColor(ContextCompat.getColor(PenarikanActivity.this,
                                R.color.menunggu));
                    }
                } else if (tab.getPosition() == 2) {
                    toolbar.setBackgroundColor(ContextCompat.getColor(PenarikanActivity.this,
                            R.color.berhasil));
                    tabLayout.setBackgroundColor(ContextCompat.getColor(PenarikanActivity.this,
                            R.color.berhasil));
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        getWindow().setStatusBarColor(ContextCompat.getColor(PenarikanActivity.this,
                                R.color.berhasil));
                    }
                } else {
                    toolbar.setBackgroundColor(ContextCompat.getColor(PenarikanActivity.this,
                            R.color.colorPrimary));
                    tabLayout.setBackgroundColor(ContextCompat.getColor(PenarikanActivity.this,
                            R.color.colorPrimary));
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        getWindow().setStatusBarColor(ContextCompat.getColor(PenarikanActivity.this,
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
