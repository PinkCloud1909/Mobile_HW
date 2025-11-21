package com.example.homework1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class Bai1Activity1811 extends AppCompatActivity {

    EditText edtName, edtMssv;
    Button btnAdd, btnUpdate;
    RecyclerView rv;
    ArrayList<Student> list = new ArrayList<>();
    StudentAdapter adapter;

    int selectedIndex = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai1_1811);

        // --------------------
        // ÁNH XẠ VIEW
        // --------------------
        edtMssv = findViewById(R.id.edtMssv);
        edtName = findViewById(R.id.edtName);
        btnAdd = findViewById(R.id.btnAdd);
        btnUpdate = findViewById(R.id.btnUpdate);
        rv = findViewById(R.id.rvStudents);

        // --------------------
        // KHỞI TẠO ADAPTER
        // --------------------
        adapter = new StudentAdapter(this, list, new StudentAdapter.ItemClickListener() {
            @Override
            public void onItemClick(int position) {
                selectedIndex = position;
                Student s = list.get(position);
                edtName.setText(s.name);
                edtMssv.setText(s.mssv);
            }

            @Override
            public void onDeleteClick(int position) {
                list.remove(position);
                adapter.notifyDataSetChanged();
            }
        });

        rv.setAdapter(adapter);
        rv.setLayoutManager(new LinearLayoutManager(this));

        // --------------------
        // NÚT ADD
        // --------------------
        btnAdd.setOnClickListener(v -> {
            String name = edtName.getText().toString().trim();
            String mssv = edtMssv.getText().toString().trim();

            if (!name.isEmpty() && !mssv.isEmpty()) {
                list.add(new Student(name, mssv));
                adapter.notifyDataSetChanged();
                edtName.setText("");
                edtMssv.setText("");
            }
        });

        // --------------------
        // NÚT UPDATE
        // --------------------
        btnUpdate.setOnClickListener(v -> {
            if (selectedIndex != -1) {
                String name = edtName.getText().toString().trim();
                String mssv = edtMssv.getText().toString().trim();

                Student s = list.get(selectedIndex);
                s.name = name;
                s.mssv = mssv;

                adapter.notifyDataSetChanged();
                selectedIndex = -1;

                edtName.setText("");
                edtMssv.setText("");
            }
        });
    }
}
