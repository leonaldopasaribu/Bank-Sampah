package com.example.banksampah.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.support.v7.widget.GridLayout;
import android.widget.Toast;

import com.example.banksampah.R;

public class HomeActivity extends AppCompatActivity {

    GridLayout mainGrid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mainGrid = (GridLayout) findViewById(R.id.mainGrid);

        //Set Event
        setSingleEvent(mainGrid);
        //setToggleEvent(mainGrid);

    }

    private void setSingleEvent(GridLayout mainGrid) {
        //Loop all child item of Main Grid
        for (int i = 0; i < mainGrid.getChildCount(); i++) {
            //You can see , all child item is CardView , so we just cast object to CardView
            CardView cardView = (CardView) mainGrid.getChildAt(i);
            final int finalI = i;

            if(i==0)
            {
                cardView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(HomeActivity.this, SetorActivity.class);
                        intent.putExtra("info","This is activity from card item index  "+finalI);
                        startActivity(intent);
                    }
                });
            }
            else if(i==1)
            {

                cardView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(HomeActivity.this, SetorActivity.class);
                        intent.putExtra("info","This is activity from card item index  "+finalI);
                        startActivity(intent);
                    }
                });
            }

        }
    }

    private BroadcastReceiver myBatteryReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            int lvl = intent.getIntExtra("level", 0);

            if (lvl <= 10) {
                Toast.makeText(context, "Baterai Lemah.",
                        Toast.LENGTH_LONG).show();
            }
            if (lvl == 100) {
                Toast.makeText(context, "Baterai Penuh.",
                        Toast.LENGTH_LONG).show();
            }
        }
    };
}
