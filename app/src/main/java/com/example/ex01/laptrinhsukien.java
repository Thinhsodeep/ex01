package com.example.ex01;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class laptrinhsukien extends AppCompatActivity {
    private String aNumber;
    private String bNumber;
    private View resultView = findViewById(R.id.resultView);
    private TextView aTextview = findViewById(R.id.aTextview);
    private TextView bTextview = findViewById(R.id.bTextview);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_laptrinhsukien);
    }
    public void tinhtong(View view){

    }
}