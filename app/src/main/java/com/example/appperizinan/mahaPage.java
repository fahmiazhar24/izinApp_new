package com.example.appperizinan;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class mahaPage extends AppCompatActivity {

    Button logout, perizinan, list, izin;
    FirebaseAuth firebaseAuth;
    FirebaseAuth.AuthStateListener AuthListner;
    Bundle extras;
    String getUserID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maha_page);
        logout = findViewById(R.id.so);
        perizinan = findViewById(R.id.izin);
        list = findViewById(R.id.daftar_izin);
        izin = findViewById(R.id.iziku_FIX);

        firebaseAuth = FirebaseAuth.getInstance();

        extras = getIntent().getExtras();

        AuthListner = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                if (firebaseAuth.getCurrentUser()==null)
                {
                    startActivity(new Intent(mahaPage.this, MainActivity.class));
                }
            }
        };
        perizinan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getUserID = extras.getString("ID");
                Intent pindah = new Intent(mahaPage.this, izinBuat.class);
                pindah.putExtra("IDEN",getUserID);
                startActivity(pindah);
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firebaseAuth.signOut();
                startActivity(new Intent(mahaPage.this, MainActivity.class));
            }
        });

        list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent daftar = new Intent(mahaPage.this, MyListData.class);
                startActivity(daftar);
            }
        });
        izin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent oke = new Intent(mahaPage.this, MyListDataStatus.class);
                startActivity(oke);
            }
        });

    }
}
