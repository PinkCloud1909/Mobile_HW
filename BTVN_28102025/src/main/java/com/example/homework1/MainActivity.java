package com.example.homework1;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView txtResult;
    String expression = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_bai1_28102025);

        txtResult = findViewById(R.id.txtResult);

        setNumberButtonListeners();
        setFunctionButtonListeners();
    }

    private void setNumberButtonListeners() {
        int[] btnIDs = {
                R.id.btn0, R.id.btn1, R.id.btn2, R.id.btn3,
                R.id.btn4, R.id.btn5, R.id.btn6,
                R.id.btn7, R.id.btn8, R.id.btn9,
                R.id.btnAdd, R.id.btnSub, R.id.btnMul, R.id.btnDiv
        };

        View.OnClickListener listener = v -> {
            Button b = (Button) v;
            String text = b.getText().toString();
            if (text.equals("x")) text = "*";  // thay ký hiệu nhân
            expression += text;
            txtResult.setText(expression);
        };

        for (int id : btnIDs) findViewById(id).setOnClickListener(listener);
    }

    private void setFunctionButtonListeners() {
        // Nút C: Xóa toàn bộ
        findViewById(R.id.btnC).setOnClickListener(v -> {
            expression = "";
            txtResult.setText("0");
        });

        // Nút CE: Xóa nội dung hiện tại
        findViewById(R.id.btnCE).setOnClickListener(v -> {
            expression = "";
            txtResult.setText("0");
        });

        // Nút BS: Xóa 1 ký tự cuối
        findViewById(R.id.btnBS).setOnClickListener(v -> {
            if (!expression.isEmpty()) {
                expression = expression.substring(0, expression.length() - 1);
                txtResult.setText(expression.isEmpty() ? "0" : expression);
            }
        });

        // Nút "=" để tính toán
        findViewById(R.id.btnEqual).setOnClickListener(v -> calculate());
    }

    private void calculate() {
        try {

            if (expression.contains("+")) {
                String[] parts = expression.split("\\+");
                int result = Integer.parseInt(parts[0]) + Integer.parseInt(parts[1]);
                txtResult.setText(String.valueOf(result));
            } else if (expression.contains("-")) {
                String[] parts = expression.split("-");
                int result = Integer.parseInt(parts[0]) - Integer.parseInt(parts[1]);
                txtResult.setText(String.valueOf(result));
            } else if (expression.contains("*")) {
                String[] parts = expression.split("\\*");
                int result = Integer.parseInt(parts[0]) * Integer.parseInt(parts[1]);
                txtResult.setText(String.valueOf(result));
            } else if (expression.contains("/")) {
                String[] parts = expression.split("/");
                int a = Integer.parseInt(parts[0]);
                int b = Integer.parseInt(parts[1]);
                if (b == 0) {
                    txtResult.setText("Error");
                } else {
                    float result = (float) a / b;
                    txtResult.setText(String.valueOf(result));
                }
            } else {
                txtResult.setText(expression);
            }
        } catch (Exception e) {
            txtResult.setText("Error");
        }
    }
}
