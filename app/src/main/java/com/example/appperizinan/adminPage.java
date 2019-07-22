package com.example.appperizinan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class adminPage extends AppCompatActivity {

    Button logout, daftIzin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_page);

        daftIzin = findViewById(R.id.dftr_izin);
        logout = findViewById(R.id.keluar);

        daftIzin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent daftar = new Intent(adminPage.this, daftarIzinAdmin.class);
                startActivity(daftar);
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent minggat = new Intent(adminPage.this, MainActivity.class);
                startActivity(minggat);
            }
        });
    }
}
