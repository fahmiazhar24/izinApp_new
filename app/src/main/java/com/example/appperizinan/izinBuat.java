package com.example.appperizinan;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
    String getNIM, getNAMA, getKELAS, getMATKUL;
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
        kls = findViewById(R.id.us4);
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
                getNAMA = nm.getText().toString().trim();
                getNIM = nik.getText().toString().trim();
                getMATKUL = kls.getText().toString().trim();
                getKELAS = mt.getText().toString().trim();

                extras = getIntent().getExtras();

                getUserID = extras.getString("IDEN");
                getReference = firebaseDatabase.getReference();

                getReference.child(getUserID)
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

    //@Override
    //public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
      //  String text = parent.getItemAtPosition(position).toString();
    //    Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
    //}

    //@Override
    //public void onNothingSelected(AdapterView<?> parent) {

    //}
}
