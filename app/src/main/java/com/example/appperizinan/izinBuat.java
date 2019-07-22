package com.example.appperizinan;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;



public class izinBuat extends AppCompatActivity implements View.OnClickListener {
    private DatabaseReference getReference;
    private FirebaseDatabase firebaseDatabase;

    Button msk;
    EditText nm, nik, kls, mt, ji, al;
    CheckBox st;
    String getNIM, getNAMA;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_izin_buat);

        msk = findViewById(R.id.confirmIzin);
        msk.setOnClickListener(this);
        nm = findViewById(R.id.us2);
        nik = findViewById(R.id.us3);
        kls = findViewById(R.id.us4);
        mt = findViewById(R.id.us5);
        ji = findViewById(R.id.us6);
        al = findViewById(R.id.us7);
        st = findViewById(R.id.chkSetuju);

        firebaseDatabase = FirebaseDatabase.getInstance();

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.confirmIzin:
                getNAMA = nm.getText().toString().trim();
                getNIM = nik.getText().toString().trim();
                getReference = firebaseDatabase.getReference();

                getReference.child("Izin").push()
                        .setValue(new dataIzin(getNAMA, getNIM))
                        .addOnSuccessListener(this, new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        nm.setText("");
                        nik.setText("");
                        Toast.makeText(izinBuat.this, "Data Tersimpan", Toast.LENGTH_SHORT).show();
                    }
                });
                break;
        }
    }

}
