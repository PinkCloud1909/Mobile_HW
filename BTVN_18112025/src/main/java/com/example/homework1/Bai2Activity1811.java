package com.example.homework1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class Bai2Activity1811 extends AppCompatActivity {

    RecyclerView rv;
    ArrayList<EmailItem> list;
    EmailAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai2_1811);

        rv = findViewById(R.id.rvEmail);

        list = new ArrayList<>();
        list.add(new EmailItem("Edurila.com", "$19 Only (First 10 spots)...", "Are you looking to learn web design?", "12:34 PM"));
        list.add(new EmailItem("Chris Abad", "Help make Campaign Monitor better", "Let us know your thoughts!", "11:22 AM"));
        list.add(new EmailItem("Tuto.com", "8h de formation gratuite", "Photoshop, SEO, Blender...", "11:04 AM"));
        list.add(new EmailItem("support", "Suivi de vos services", "SAS OVH - http://www.ovh.com", "10:26 AM"));
        list.add(new EmailItem("Matt from Ionic", "The new Ionic Creator", "Announcing the all-new creator...", "09:47 AM"));

        adapter = new EmailAdapter(this, list);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(adapter);
    }
}
