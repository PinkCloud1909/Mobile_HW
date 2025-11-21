package com.example.homework1;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.*;
import java.util.HashMap;

public class MainActivity0411 extends AppCompatActivity {
    EditText edtAmount;
    Spinner spnFrom, spnTo;
    TextView tvResult;
    Button btnConvert;

    HashMap<String, Double> rates;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai1_0411);

        edtAmount = findViewById(R.id.edtAmount);
        spnFrom = findViewById(R.id.spnFrom);
        spnTo = findViewById(R.id.spnTo);
        tvResult = findViewById(R.id.tvResult);
        btnConvert = findViewById(R.id.btnConvert);

        String[] currencies = {"VND", "USD", "EUR", "JPY", "GBP", "AUD", "CAD", "CHF", "CNY", "KRW"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, currencies);
        spnFrom.setAdapter(adapter);
        spnTo.setAdapter(adapter);

        // Giả lập tỷ giá
        rates = new HashMap<>();
        rates.put("VND", 1.0);
        rates.put("USD", 25000.0);
        rates.put("EUR", 27000.0);
        rates.put("JPY", 170.0);
        rates.put("GBP", 32000.0);
        rates.put("AUD", 16500.0);
        rates.put("CAD", 18000.0);
        rates.put("CHF", 28500.0);
        rates.put("CNY", 3500.0);
        rates.put("KRW", 19.0);

        btnConvert.setOnClickListener(v -> {
            String from = spnFrom.getSelectedItem().toString();
            String to = spnTo.getSelectedItem().toString();
            String amountStr = edtAmount.getText().toString();

            if (amountStr.isEmpty()) {
                Toast.makeText(this, "Vui lòng nhập số tiền", Toast.LENGTH_SHORT).show();
                return;
            }

            double amount = Double.parseDouble(amountStr);
            double vndValue = amount * rates.get(from);
            double result = vndValue / rates.get(to);
            tvResult.setText(String.format("%.2f %s", result, to));
        });
    }
}
