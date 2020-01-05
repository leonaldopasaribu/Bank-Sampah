package com.example.banksampah.fragment;

import android.os.Bundle;
import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.banksampah.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.DateFormat;
import java.util.Calendar;

public class PenarikanFragment extends Fragment {
    private DatabaseReference mDatabaseRef;
    public PenarikanFragment(){

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_penarikan, container, false);

        //Get Tanggal
        Calendar calendar = Calendar.getInstance();
        final String currentDate = DateFormat.getDateInstance(DateFormat.FULL).format(calendar.getTime());

        mDatabaseRef = FirebaseDatabase.getInstance().getReference().child("PenarikanUang");
        final EditText jumlahPenarikan = (EditText) view.findViewById(R.id.jumlahPenarikan);
        Button penarikanBtn = (Button) view.findViewById(R.id.btnPenarikan);
        penarikanBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String jumlah = jumlahPenarikan.getText().toString();

                if (TextUtils.isEmpty(jumlah)) {
                    Toast.makeText(getActivity().getApplicationContext(), "Please fill all fields", Toast.LENGTH_LONG).show();
                } else {
                    DatabaseReference data = mDatabaseRef.push();
                    data.child("jumlah").setValue(jumlah);
                    data.child("date").setValue(currentDate);
                    jumlahPenarikan.setText("");

                }
            }
        });

        return view;
    }
}
