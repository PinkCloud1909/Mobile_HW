package com.example.homework1;

import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.widget.FrameLayout;

public class MainActivityBai228102025 extends AppCompatActivity {

    EditText edtFirstName, edtLastName, edtBirthday, edtAddress, edtEmail;
    RadioGroup rgGender;
    RadioButton rbMale, rbFemale;
    CheckBox cbAgree;
    Button btnSelect, btnRegister;
    CalendarView calendarView;
    FrameLayout calendarContainer;
    boolean isCalendarVisible = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // ⚠️ setContentView phải được gọi TRƯỚC khi findViewById
        setContentView(R.layout.activity_bai2);

        // Ánh xạ view
        edtFirstName = findViewById(R.id.edtFirstName);
        edtLastName = findViewById(R.id.edtLastName);
        edtBirthday = findViewById(R.id.edtBirthday);
        edtAddress = findViewById(R.id.edtAddress);
        edtEmail = findViewById(R.id.edtEmail);
        rgGender = findViewById(R.id.rgGender);
        rbMale = findViewById(R.id.rbMale);
        rbFemale = findViewById(R.id.rbFemale);
        cbAgree = findViewById(R.id.cbAgree);
        btnSelect = findViewById(R.id.btnSelect);
        btnRegister = findViewById(R.id.btnRegister);
        calendarView = findViewById(R.id.calendarView);
        calendarContainer = findViewById(R.id.calendarContainer);

        // ===== Xử lý khi bấm nút Select (hiện/ẩn CalendarView) =====
        btnSelect.setOnClickListener(v -> {
            Toast.makeText(this, "Bạn vừa bấm Select", Toast.LENGTH_SHORT).show();

            if (calendarContainer.getVisibility() == View.GONE) {
                calendarContainer.setVisibility(View.VISIBLE);
                calendarView.requestFocus();
            } else {
                calendarContainer.setVisibility(View.GONE);
            }
        });

        // ===== Khi chọn ngày trong CalendarView =====
        calendarView.setOnDateChangeListener((view, year, month, dayOfMonth) -> {
            String date = dayOfMonth + "/" + (month + 1) + "/" + year;
            edtBirthday.setText(date);
            edtBirthday.setTextColor(Color.BLACK);
            calendarContainer.setVisibility(View.GONE);
        });

        // ===== Khi bấm Register =====
        btnRegister.setOnClickListener(v -> {
            boolean valid = true;

            // Reset màu nền các ô
            edtFirstName.setBackgroundColor(Color.TRANSPARENT);
            edtLastName.setBackgroundColor(Color.TRANSPARENT);
            edtBirthday.setBackgroundColor(Color.TRANSPARENT);
            edtAddress.setBackgroundColor(Color.TRANSPARENT);
            edtEmail.setBackgroundColor(Color.TRANSPARENT);

            // Lấy dữ liệu nhập
            String fn = edtFirstName.getText().toString().trim();
            String ln = edtLastName.getText().toString().trim();
            String bd = edtBirthday.getText().toString().trim();
            String ad = edtAddress.getText().toString().trim();
            String em = edtEmail.getText().toString().trim();

            // Kiểm tra từng trường
            if (fn.isEmpty()) {
                edtFirstName.setBackgroundColor(Color.rgb(255, 200, 200));
                valid = false;
            }
            if (ln.isEmpty()) {
                edtLastName.setBackgroundColor(Color.rgb(255, 200, 200));
                valid = false;
            }
            if (bd.isEmpty()) {
                edtBirthday.setBackgroundColor(Color.rgb(255, 200, 200));
                valid = false;
            }
            if (ad.isEmpty()) {
                edtAddress.setBackgroundColor(Color.rgb(255, 200, 200));
                valid = false;
            }
            if (em.isEmpty()) {
                edtEmail.setBackgroundColor(Color.rgb(255, 200, 200));
                valid = false;
            }
            if (rgGender.getCheckedRadioButtonId() == -1) {
                Toast.makeText(this, "Vui lòng chọn giới tính", Toast.LENGTH_SHORT).show();
                valid = false;
            }
            if (!cbAgree.isChecked()) {
                Toast.makeText(this, "Bạn phải đồng ý điều khoản sử dụng", Toast.LENGTH_SHORT).show();
                valid = false;
            }

            // Hiển thị kết quả
            if (valid) {
                Toast.makeText(this, "Đăng ký thành công!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Vui lòng điền đầy đủ thông tin!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
