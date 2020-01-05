package com.example.banksampah.fragment;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.banksampah.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.DateFormat;
import java.util.Calendar;

public class SetorFragment extends Fragment {
    private DatabaseReference mDatabaseRef;

    public SetorFragment(){

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_setor, container, false);

        //Get Tanggal
        Calendar calendar = Calendar.getInstance();
        final String currentDate = DateFormat.getDateInstance(DateFormat.FULL).format(calendar.getTime());

        mDatabaseRef = FirebaseDatabase.getInstance().getReference().child("SetorSampah");
        final Spinner jenisSampah = (Spinner) view.findViewById(R.id.jenisSampah);
        final EditText beratSampah = (EditText) view.findViewById(R.id.beratSampah);
        Button setorBtn = (Button) view.findViewById(R.id.btnSetor);
        setorBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String jenis = jenisSampah.getSelectedItem().toString();
                String berat = beratSampah.getText().toString();

                if (TextUtils.isEmpty(jenis) || TextUtils.isEmpty(berat)) {
                    Toast.makeText(getActivity().getApplicationContext(), "Please fill all fields", Toast.LENGTH_LONG).show();
                } else {

                    DatabaseReference data = mDatabaseRef.push();
                    data.child("jenis").setValue(jenis);
                    data.child("berat").setValue(berat,"kg");
                    data.child("date").setValue(currentDate);

                    jenisSampah.setPrompt("");
                    beratSampah.setText("");
                }
            }
        });

        return view;
    }

    @Override
    public void onAttach(Context context) {super.onAttach(context);}

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
