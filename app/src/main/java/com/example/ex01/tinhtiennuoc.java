package com.example.ex01;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class tinhtiennuoc extends AppCompatActivity {
    private EditText edtCustomerName, edtOldIndex, edtNewIndex;
    private Button btnCalculate, btnClear, btnClose;
    private TextView txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tinhtiennuoc);

        edtCustomerName = findViewById(R.id.edtCustomerName);
        edtOldIndex = findViewById(R.id.edtOldIndex);
        edtNewIndex = findViewById(R.id.edtNewIndex);
        btnCalculate = findViewById(R.id.btnCalculate);
        btnClear = findViewById(R.id.btnClear);
        btnClose = findViewById(R.id.btnClose);
        txtResult = findViewById(R.id.txtResult);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateBill();
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
                confirmClose(); // Gọi hàm xác nhận khi nhấn nút đóng
            }
        });
    }

    private void calculateBill() {
        String customerName = edtCustomerName.getText().toString();
        int oldIndex;
        int newIndex;

        // Kiểm tra và lấy dữ liệu từ EditText
        try {
            oldIndex = Integer.parseInt(edtOldIndex.getText().toString());
            newIndex = Integer.parseInt(edtNewIndex.getText().toString());

            // Kiểm tra xem chỉ số cũ có nhỏ hơn chỉ số mới hay không
            if (oldIndex >= newIndex) {
                Toast.makeText(this, "Chỉ số cũ phải nhỏ hơn chỉ số mới.", Toast.LENGTH_SHORT).show();
                return;
            }
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Vui lòng nhập số hợp lệ.", Toast.LENGTH_SHORT).show();
            return;
        }

        // Số nước tiêu thụ
        int consumedWater = newIndex - oldIndex;

        // Tính tiền dựa trên số lượng tiêu thụ
        double totalCost;
        if (consumedWater <= 50) {
            totalCost = consumedWater * 1484; // Giá cho 50 m³ đầu tiên
        } else if (consumedWater <= 100) {
            totalCost = 50 * 1484 + (consumedWater - 50) * 1533; // 50 m³ đầu và phần vượt
        } else if (consumedWater <= 200) {
            totalCost = 50 * 1484 + 50 * 1533 + (consumedWater - 100) * 1786; // 50 m³ đầu, 50 m³ tiếp theo, và phần vượt
        } else {
            totalCost = 50 * 1484 + 50 * 1533 + 100 * 1786 + (consumedWater - 200) * 2242; // Các mức giá khác
        }

        // Hiển thị kết quả trong TextView
        txtResult.setText("Tổng số KW của khách hàng " + customerName + " đã sử dụng là " + consumedWater + " KW, tổng tiền: " + totalCost + " VND");
    }


    private void clearInputs() {
        edtCustomerName.setText("");
        edtOldIndex.setText("");
        edtNewIndex.setText("");
        txtResult.setText(""); // Xóa kết quả
    }

    private void confirmClose() {
        new AlertDialog.Builder(this)
                .setTitle("Xác nhận")
                .setMessage("Bạn có chắc chắn muốn đóng ứng dụng không?")
                .setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        finish(); // Đóng activity
                    }
                })
                .setNegativeButton("Không", null) // Không làm gì khi nhấn "Không"
                .show();
    }
}
