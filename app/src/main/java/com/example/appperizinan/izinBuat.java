package com.example.appperizinan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;



public class izinBuat extends AppCompatActivity implements View.OnClickListener{
    private DatabaseReference getReference;
    private FirebaseDatabase firebaseDatabase;

    Spinner spinner, sphinner;

    Button msk;
    EditText nm, nik, kls, mt, ji, al;
    CheckBox st;
    String getNIM, getNAMA, getKELAS, getMATKUL, getJENIS, getALASAN;
    String getUserID;
    Bundle extras;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_izin_buat);

        msk = findViewById(R.id.confirmIzin);
        msk.setOnClickListener(this);
        nm = findViewById(R.id.us2);
        nik = findViewById(R.id.us3);
        mt = findViewById(R.id.us5);
        al = findViewById(R.id.us7);
        st = findViewById(R.id.chkSetuju);

        sphinner = findViewById(R.id.spinner2);
        spinner = findViewById(R.id.spinner1);

        firebaseDatabase = FirebaseDatabase.getInstance();

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.costom_izin, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        //spinner.setOnItemClickListener(this);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(getBaseContext(),parent.getItemAtPosition(position)+ "", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this,R.array.costom_kelas, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sphinner.setAdapter(adapter1);
        sphinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.confirmIzin:

                if (st.isChecked() == true){
                    getNAMA = nm.getText().toString().trim();
                    getNIM = nik.getText().toString().trim();
                    getKELAS = spinner.getSelectedItem().toString();
                    getMATKUL = mt.getText().toString().trim();
                    getJENIS = sphinner.getSelectedItem().toString();
                    getALASAN = al.getText().toString().trim();

                    if (TextUtils.isEmpty(getNAMA)) {
                        nm.setError("Isi Nama terlebih dahulu");
                        //Toast.makeText(getApplicationContext(), "Please enter user id", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    if (TextUtils.isEmpty(getNIM)) {
                        nik.setError("Isi NIM terlebih dahulu");
                        //Toast.makeText(getApplicationContext(), "Enter Password", Toast.LENGTH_SHORT).show();
                        return;
                    }if (TextUtils.isEmpty(getMATKUL)) {
                        mt.setError("Isi Nama MATKUL");
                        //Toast.makeText(getApplicationContext(), "Enter Password", Toast.LENGTH_SHORT).show();
                        return;
                    }if (TextUtils.isEmpty(getALASAN)) {
                        al.setError("Alasan Tidak boleh Kosong");
                        //Toast.makeText(getApplicationContext(), "Enter Password", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    extras = getIntent().getExtras();

                    getUserID = extras.getString("IDEN");
                    getReference = firebaseDatabase.getReference();

                    getReference.child("Mahasiswa").child(getUserID).push()
                            .setValue(new dataIzin(getNAMA, getNIM, getKELAS, getMATKUL, getJENIS, getALASAN))
                            .addOnSuccessListener(this, new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {
                                    nm.setText("");
                                    nik.setText("");
                                    mt.setText("");
                                    al.setText("");
                                    Intent yok = new Intent(izinBuat.this, mahaPage.class);
                                    startActivity(yok);
                                    Toast.makeText(izinBuat.this, "Data Tersimpan", Toast.LENGTH_SHORT).show();
                                }
                            });
                }else {
                    Toast.makeText(izinBuat.this, "Anda Belum Menyetujuinya", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    //@Override
    //public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
      //  String text = parent.getItemAtPosition(position).toString();
    //    Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
    //}

    //@Override
    //public void onNothingSelected(AdapterView<?> parent) {

    //}
}
