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
    private EditText statustxt, dateTXT, namaTXT, nimTXT, matkulTXT, kelasTXT, jenisTXT, alasanTXT;
    private Button update;
    private DatabaseReference database;
    private FirebaseAuth auth;
    private String cekSTATUS, cekTANGGAL, cekNAMA, cekNIM, cekKELAS, cekMATKUL, cekJENIS, cekALASAN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terima_izin);

        statustxt = findViewById(R.id.statusku);
        dateTXT = findViewById(R.id.tanggal);
        namaTXT = findViewById(R.id.nama);
        nimTXT = findViewById(R.id.nim);
        kelasTXT = findViewById(R.id.kelas);
        matkulTXT = findViewById(R.id.mata_kuliah);
        jenisTXT = findViewById(R.id.jenis_izin);
        alasanTXT = findViewById(R.id.alasan);

        dateTXT.setEnabled(false);
        namaTXT.setEnabled(false);
        nimTXT.setEnabled(false);
        kelasTXT.setEnabled(false);
        matkulTXT.setEnabled(false);
        jenisTXT.setEnabled(false);
        alasanTXT.setEnabled(false);

        update = findViewById(R.id.update);

        database = FirebaseDatabase.getInstance().getReference();
        getData();
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Mendapatkan Data Mahasiswa yang akan dicek
                cekSTATUS = statustxt.getText().toString();
                cekTANGGAL = dateTXT.getText().toString();
                cekNAMA = namaTXT.getText().toString();
                cekNIM = nimTXT.getText().toString();
                cekKELAS = kelasTXT.getText().toString();
                cekMATKUL = matkulTXT.getText().toString();
                cekJENIS = jenisTXT.getText().toString();
                cekALASAN = alasanTXT.getText().toString();

                if(isEmpty(cekSTATUS)){
                    Toast.makeText(terimaIzin.this, "Data tidak boleh ada yang kosong", Toast.LENGTH_SHORT).show();
                }else {
//                      Menjalankan proses update data.
//                      Method Setter digunakan untuk mendapakan data baru yang diinputkan User.
                    dataIzinAdmin setIzin = new dataIzinAdmin();
                    setIzin.setStatus(statustxt.getText().toString());
                    setIzin.setDate(dateTXT.getText().toString());
                    setIzin.setNama(namaTXT.getText().toString());
                    setIzin.setNim(nimTXT.getText().toString());
                    setIzin.setKelas(kelasTXT.getText().toString());
                    setIzin.setMatkul(matkulTXT.getText().toString());
                    setIzin.setJenisIzin(jenisTXT.getText().toString());
                    setIzin.setAlasan(alasanTXT.getText().toString());
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
        final String getTANGGAL = getIntent().getExtras().getString("dataTANGGAL");
        final String getNAMA = getIntent().getExtras().getString("dataNAMA");
        final String getNIM = getIntent().getExtras().getString("dataNIM");
        final String getKELAS = getIntent().getExtras().getString("dataKELAS");
        final String getMATKUL = getIntent().getExtras().getString("dataMATAKUL");
        final String getJENIS = getIntent().getExtras().getString("dataJENIS");
        final String getALASAN = getIntent().getExtras().getString("dataALASAN");

        statustxt.setText(getSTATUS);
        dateTXT.setText(getTANGGAL);
        namaTXT.setText(getNAMA);
        nimTXT.setText(getNIM);
        kelasTXT.setText(getKELAS);
        matkulTXT.setText(getMATKUL);
        jenisTXT.setText(getJENIS);
        alasanTXT.setText(getALASAN);

    }

    //Proses Update data yang sudah ditentukan
    private void updateMahasiswa(dataIzinAdmin mahasiswa){
        String getKey = getIntent().getExtras().getString("getPrimaryKey");
        database.child("Admin")
                .child("Sakit")
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
