package com.example.ex01;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainCitizen extends AppCompatActivity {
    private Button btnCitizenList, btnAddCitizen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_citizen);

        btnCitizenList = findViewById(R.id.btnCitizenList);
        btnAddCitizen = findViewById(R.id.btnAddCitizen);

        btnCitizenList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainCitizen.this, CitizenListActivity.class);
                startActivity(intent);
            }
        });

        btnAddCitizen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainCitizen.this, AddCitizenActivity.class);
                startActivity(intent);
            }
        });

    }
}
