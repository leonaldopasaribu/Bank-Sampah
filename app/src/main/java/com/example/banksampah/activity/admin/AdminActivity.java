package com.example.banksampah.activity.admin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.gridlayout.widget.GridLayout;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.banksampah.R;
import com.example.banksampah.activity.user.PenarikanActivity;
import com.example.banksampah.activity.user.SetorActivity;

public class AdminActivity extends AppCompatActivity {
    Button LogOutButton;
    GridLayout mainGrid;
    public static final String TAG="LOGIN";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        LogOutButton =(Button)findViewById(R.id.btnLogout);

        mainGrid = (GridLayout) findViewById(R.id.mainGrid);
        Intent intent = getIntent();

        //Set Event
        setSingleEvent(mainGrid);
        //setToggleEvent(mainGrid);

        LogOutButton.setOnClickListener(new View.OnClickListener() {
            // @Override
            public void onClick(View v) {
                //Finishing current DashBoard activity on button click.
                finish();

                Toast.makeText(AdminActivity.this,"Log Out Successfull", Toast.LENGTH_LONG).show();
                //Intent intent=new Intent(DashboardActivity.this,LoginActivity.class);
                //startActivity(intent);
               /*if (v.getId() == R.id.button1) {
                    AuthUI.getInstance()
                            .signOut(this)
                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                public void onComplete(@NonNull Task<Void> task) {
                                    // user is now signed out
                                    startActivity(new Intent(DashboardActivity.this, LoginActivity.class));
                                    finish();
                                }
                            });
                }*/

            }
        });
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
                        Intent intent = new Intent(AdminActivity.this, SetorActivity.class);
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
                        Intent intent = new Intent(AdminActivity.this, AdminPenarikanActivity.class);
                        intent.putExtra("info","This is activity from card item index  "+finalI);
                        startActivity(intent);
                    }
                });
            }
            else if(i==2)
            {

                cardView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(AdminActivity.this, SampahActivity.class);
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
