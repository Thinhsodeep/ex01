package com.example.ex01;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AddCitizenActivity extends AppCompatActivity {
    private EditText edtName, edtIdentification, edtAddress;
    private Button btnSave, btnClear, btnClose;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_citizen);

        edtName = findViewById(R.id.edtName);
        edtIdentification = findViewById(R.id.edtId);
        edtAddress = findViewById(R.id.edtAddress);
        btnSave = findViewById(R.id.btnSave);
        btnClear = findViewById(R.id.btnClear);
        btnClose = findViewById(R.id.btnClose);
        databaseHelper = new DatabaseHelper(this);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addCitizen();
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearInputs();
            }
        });

        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Đóng activity
            }
        });
    }

    private void addCitizen() {
        String name = edtName.getText().toString();
        String identification = edtIdentification.getText().toString();
        String address = edtAddress.getText().toString();

        if (name.isEmpty() || identification.isEmpty() || address.isEmpty()) {
            Toast.makeText(this, "Vui lòng điền đầy đủ thông tin.", Toast.LENGTH_SHORT).show();
            return;
        }

        Citizen citizen = new Citizen(name, identification, address);
        databaseHelper.addCitizen(citizen);
        Toast.makeText(this, "Công dân đã được thêm.", Toast.LENGTH_SHORT).show();
        clearInputs();
    }

    private void clearInputs() {
        edtName.setText("");
        edtIdentification.setText("");
        edtAddress.setText("");
    }
}
