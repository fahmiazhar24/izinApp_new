package com.example.appperizinan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import static android.text.TextUtils.isEmpty;

public class terimaIzin extends AppCompatActivity {

//    private Spinner status;
    private EditText statustxt;
    private Button update;
    private DatabaseReference database;
    private FirebaseAuth auth;
    private String cekSTATUS, cekNama, cekJurusan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terima_izin);

        statustxt = findViewById(R.id.statusku);
        update = findViewById(R.id.update);

        database = FirebaseDatabase.getInstance().getReference();
        getData();
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Mendapatkan Data Mahasiswa yang akan dicek
                cekSTATUS = statustxt.getText().toString();

                //Mengecek agar tidak ada data yang kosong, saat proses update
                if(isEmpty(cekSTATUS)){
                    Toast.makeText(terimaIzin.this, "Data tidak boleh ada yang kosong", Toast.LENGTH_SHORT).show();
                }else {
                    /*
                      Menjalankan proses update data.
                      Method Setter digunakan untuk mendapakan data baru yang diinputkan User.
                    */

                    dataIzinAdmin setIzin = new dataIzinAdmin();
                    setIzin.setStatus(statustxt.getText().toString());
                    updateMahasiswa(setIzin);
                }
            }
        });
    }

    // Mengecek apakah ada data yang kosong, sebelum diupdate
    private boolean isEmpty(String s){
        return TextUtils.isEmpty(s);
    }

    //Menampilkan data yang akan di update
    private void getData(){
        //Menampilkan data dari item yang dipilih sebelumnya
        final String getSTATUS = getIntent().getExtras().getString("dataSTATUS");
        statustxt.setText(getSTATUS);
    }

    //Proses Update data yang sudah ditentukan
    private void updateMahasiswa(dataIzinAdmin mahasiswa){
        String getKey = getIntent().getExtras().getString("getPrimaryKey");
        database.child("Mahasiswa")
                .child("Acara Mendadak")
                .child(getKey)
                .setValue(mahasiswa)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        statustxt.setText("");
                        Intent i = new Intent(terimaIzin.this, MyListDataAdmin.class);
                        Toast.makeText(terimaIzin.this, "Data Berhasil diubah", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                });
    }
}
