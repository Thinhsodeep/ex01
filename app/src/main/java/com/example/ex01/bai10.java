package com.example.ex01;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class bai10 extends AppCompatActivity {

    ArrayList<Customer> customersList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai10);

        Button btnCalculate = findViewById(R.id.btnCalculate);
        Button btnExit = findViewById(R.id.btnExit);
        EditText edtCustomerName = findViewById(R.id.edtCustomerName);
        EditText edtQuantity = findViewById(R.id.edtQuantity);
        CheckBox chkVip = findViewById(R.id.chkVip);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = edtCustomerName.getText().toString();
                int quantity = Integer.parseInt(edtQuantity.getText().toString());
                boolean isVip = chkVip.isChecked();

                // Calculate the total price
                double pricePerBook = 20000;
                double total = quantity * pricePerBook;
                if (isVip) {
                    total *= 0.9;  // Apply 10% discount for VIP
                }

                // Store the data for statistics
                customersList.add(new Customer(name, quantity, total, isVip));

                // Show total in a Toast
                Toast.makeText(bai10.this, "Total: " + total, Toast.LENGTH_SHORT).show();
            }
        });

        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(bai10.this)
                        .setMessage("Do you really want to exit?")
                        .setPositiveButton("Yes", (dialog, which) -> finish())
                        .setNegativeButton("No", null)
                        .show();
            }
        });
    }

    public class Customer {
        String name;
        int quantity;
        double total;
        boolean isVip;

        public Customer(String name, int quantity, double total, boolean isVip) {
            this.name = name;
            this.quantity = quantity;
            this.total = total;
            this.isVip = isVip;
        }
    }
}
