package com.example.appperizinan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button admin, maha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        admin = findViewById(R.id.ad);
        maha = findViewById(R.id.mh);
        admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ad = new Intent(MainActivity.this, loginAdmin.class);
                startActivity(ad);
            }
        });
        maha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mh = new Intent(MainActivity.this, loginMaha.class);
                startActivity(mh);
            }
        });

    }
}
