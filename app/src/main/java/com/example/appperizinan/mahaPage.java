package com.example.appperizinan;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class mahaPage extends AppCompatActivity {

    Button logout, perizinan;
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

        firebaseAuth = FirebaseAuth.getInstance();
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
                extras = getIntent().getExtras();

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

    }
}
