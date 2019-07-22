package com.example.appperizinan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class loginAdmin extends AppCompatActivity {

    EditText user, pass;
    Button lanjut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_admin);

        user = findViewById(R.id.mh);
        pass = findViewById(R.id.ps);
        lanjut = findViewById(R.id.ad);


        lanjut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Check();
            }
        });
    }

    public void Check(){
        if (user.getText().toString().equals("admin") &&
        pass.getText().toString().equals("admin123")){
            Toast.makeText(this, "Login Success", Toast.LENGTH_SHORT).show();
            Intent yok = new Intent(loginAdmin.this, adminPage.class);
            startActivity(yok);
        }
        else{
            Toast.makeText(this, "Login Failed", Toast.LENGTH_SHORT).show();
        }
    }
}
