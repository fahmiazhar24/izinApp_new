package com.example.appperizinan;


import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class loginMaha extends AppCompatActivity {

    private final String TAG = "";
    EditText us, ps;
    Button lg;
    FirebaseAuth firebaseAuth;
    ProgressBar progressBar;
    FirebaseAuth.AuthStateListener AuthListner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        firebaseAuth = FirebaseAuth.getInstance();

        if (firebaseAuth.getCurrentUser() != null) {
            startActivity(new Intent(loginMaha.this, mahaPage.class));
            finish();
        }

        setContentView(R.layout.activity_login_maha);
        us = findViewById(R.id.us);
        ps = findViewById(R.id.ps);
        lg = findViewById(R.id.lg);
        progressBar = findViewById(R.id.progressBar);

        firebaseAuth = FirebaseAuth.getInstance();

        lg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = us.getText().toString();
                final String password = ps.getText().toString();
                if (TextUtils.isEmpty(user)) {
                    Toast.makeText(getApplicationContext(), "Please enter user id", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(getApplicationContext(), "Enter Password", Toast.LENGTH_SHORT).show();
                    return;
                }
                progressBar.setVisibility(View.VISIBLE);


                firebaseAuth.signInWithEmailAndPassword(user, password)
                        .addOnCompleteListener(loginMaha.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                progressBar.setVisibility(View.GONE);
                                if (task.isSuccessful()) {
                                    // there was an error
                                    Log.d(TAG, "signInWithEmail:success");
                                    Intent intent = new Intent(loginMaha.this, mahaPage.class);
                                    startActivity(intent);
                                    finish();
                                } else {
                                    Log.d(TAG, "singInWithEmail:Fail");
                                    Toast.makeText(loginMaha.this, getString(R.string.login_failed), Toast.LENGTH_LONG).show();
                                }
                            }
                        });

            }
        });

        AuthListner = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                if (firebaseAuth.getCurrentUser() != null) {
                    startActivity(new Intent(loginMaha.this, mahaPage.class));
                }
            }
        };
    }
}
