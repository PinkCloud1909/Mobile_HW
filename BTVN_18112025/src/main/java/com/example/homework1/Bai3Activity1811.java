package com.example.homework1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
public class Bai3Activity1811 extends AppCompatActivity {

    RecyclerView rvSuggested, rvRecommended;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai3_1811);

        rvSuggested = findViewById(R.id.rvSuggested);
        rvRecommended = findViewById(R.id.rvRecommended);

        // Danh sách Suggested (dọc)
        ArrayList<AppSuggested> listV = new ArrayList<>();
        listV.add(new AppSuggested(R.drawable.mech, "Mech Assemble", "Action • Role Playing", "4.8 ★ • 624 MB"));
        listV.add(new AppSuggested(R.drawable.mu, "MU: Hồng Hoả Đào", "Role Playing", "4.8 ★ • 339 MB"));
        listV.add(new AppSuggested(R.drawable.war, "War Inc: Rising", "Strategy • Tower defense", "4.9 ★ • 231 MB"));


        rvSuggested.setLayoutManager(new LinearLayoutManager(this));
        rvSuggested.setAdapter(new StoreSuggestedAdapter(this, listV));

        // Danh sách Recommended (ngang)
        ArrayList<AppRecommend> listH = new ArrayList<>();
        listH.add(new AppRecommend(R.drawable.suno, "Suno"));
        listH.add(new AppRecommend(R.drawable.claude, "Claude"));
        listH.add(new AppRecommend(R.drawable.dramabox, "DramaBox"));


        rvRecommended.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        rvRecommended.setAdapter(new StoreRecommendAdapter(this, listH));
    }
}
