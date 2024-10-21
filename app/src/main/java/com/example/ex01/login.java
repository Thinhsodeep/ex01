package com.example.ex01;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);

        Button loginbutton = findViewById(R.id.btnLogin);
        Button logoutbutton = findViewById(R.id.btnLogout);
        loginbutton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                // Hiển thị Toast với văn bản "Button clicked!"
                Toast.makeText(getApplication(), "ThinhSoDeep: Ban dang Click vao nut login", Toast.LENGTH_SHORT).show();
            }
        });
        logoutbutton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                // Hiển thị Toast với văn bản "Button clicked!"
                Toast.makeText(getApplication(), "ThinhSoDeep: Ban dang Click vao nut logout", Toast.LENGTH_SHORT).show();
            }
        });


    }

}