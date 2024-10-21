package com.example.ex01;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class CitizenListActivity extends AppCompatActivity {
    private ListView listView;
    private Button btnBack; // Thêm biến cho nút Quay lại
    private DatabaseHelper databaseHelper;
    private ArrayAdapter<String> adapter;
    private ArrayList<String> citizenNames;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_citizen_list);

        listView = findViewById(R.id.listView); // Liên kết ListView với giao diện
        btnBack = findViewById(R.id.btnBack); // Liên kết nút Quay lại
        databaseHelper = new DatabaseHelper(this);
        citizenNames = new ArrayList<>();

        loadCitizenList(); // Gọi phương thức tải dữ liệu

        // Thiết lập sự kiện nhấn cho nút Quay lại
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Quay lại màn hình trước
            }
        });
    }

    private void loadCitizenList() {
        ArrayList<Citizen> citizens = databaseHelper.getAllCitizens(); // Lấy dữ liệu từ SQLite
        for (Citizen citizen : citizens) {
            citizenNames.add(citizen.getName() + " - " + citizen.getIdentification() + " - " + citizen.getAddress());
        }

        // Cài đặt ArrayAdapter để hiển thị danh sách
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, citizenNames);
        listView.setAdapter(adapter);
    }
}
