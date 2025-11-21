package com.example.homework1;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.*;
import java.util.ArrayList;

public class MainActivity04112 extends AppCompatActivity {

    EditText edtNumber;
    RadioGroup rdGroup;
    RadioButton rdChan, rdLe, rdNguyenTo, rdHoanHao, rdChinhPhuong, rdFibo;
    ListView lvResult;
    ArrayAdapter<Integer> adapter;
    ArrayList<Integer> listNumbers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai2_0411);

        // Ánh xạ View
        edtNumber = findViewById(R.id.edtNumber);
        rdGroup = findViewById(R.id.rdGroup);
        rdChan = findViewById(R.id.rdChan);
        rdLe = findViewById(R.id.rdLe);
        rdNguyenTo = findViewById(R.id.rdNguyenTo);
        rdHoanHao = findViewById(R.id.rdHoanHao);
        rdChinhPhuong = findViewById(R.id.rdChinhPhuong);
        rdFibo = findViewById(R.id.rdFibo);
        lvResult = findViewById(R.id.lvResult);

        // Khởi tạo danh sách và adapter
        listNumbers = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listNumbers);
        lvResult.setAdapter(adapter);

        // Cập nhật khi nhập số mới
        edtNumber.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                updateList();
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });

        // Cập nhật khi đổi loại số
        rdGroup.setOnCheckedChangeListener((group, checkedId) -> updateList());
    }

    private void updateList() {
        listNumbers.clear();
        String nStr = edtNumber.getText().toString();
        if (nStr.isEmpty()) {
            adapter.notifyDataSetChanged();
            return;
        }

        int n = Integer.parseInt(nStr);
        for (int i = 1; i <= n; i++) {
            if (rdChan.isChecked() && i % 2 == 0) listNumbers.add(i);
            else if (rdLe.isChecked() && i % 2 != 0) listNumbers.add(i);
            else if (rdNguyenTo.isChecked() && isPrime(i)) listNumbers.add(i);
            else if (rdHoanHao.isChecked() && isPerfect(i)) listNumbers.add(i);
            else if (rdChinhPhuong.isChecked() && isSquare(i)) listNumbers.add(i);
            else if (rdFibo.isChecked() && isFibo(i)) listNumbers.add(i);
        }

        if (listNumbers.isEmpty()) {
            Toast.makeText(this, "Không có số nào thỏa mãn", Toast.LENGTH_SHORT).show();
        }
        adapter.notifyDataSetChanged();
    }

    private boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    private boolean isPerfect(int n) {
        int sum = 0;
        for (int i = 1; i < n; i++) {
            if (n % i == 0) sum += i;
        }
        return sum == n && n != 0;
    }

    private boolean isSquare(int n) {
        int root = (int) Math.sqrt(n);
        return root * root == n;
    }

    private boolean isFibo(int n) {
        int a = 0, b = 1;
        if (n == 0 || n == 1) return true;
        while (b < n) {
            int c = a + b;
            a = b;
            b = c;
        }
        return b == n;
    }
}
