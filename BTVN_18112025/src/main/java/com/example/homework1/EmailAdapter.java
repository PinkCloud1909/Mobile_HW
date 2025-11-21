package com.example.homework1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class EmailAdapter extends RecyclerView.Adapter<EmailAdapter.ViewHolder> {

    Context context;
    ArrayList<EmailItem> list;

    public EmailAdapter(Context context, ArrayList<EmailItem> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_email, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        EmailItem e = list.get(position);
        holder.txtAvatar.setText(e.avatarChar);
        holder.txtSender.setText(e.sender);
        holder.txtTitle.setText(e.title);
        holder.txtPreview.setText(e.preview);
        holder.txtTime.setText(e.time);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtAvatar, txtSender, txtTitle, txtPreview, txtTime;
        ImageView imgStar;

        ViewHolder(View itemView) {
            super(itemView);
            txtAvatar = itemView.findViewById(R.id.txtAvatar);
            txtSender = itemView.findViewById(R.id.txtSender);
            txtTitle = itemView.findViewById(R.id.txtTitle);
            txtPreview = itemView.findViewById(R.id.txtPreview);
            txtTime = itemView.findViewById(R.id.txtTime);
            imgStar = itemView.findViewById(R.id.imgStar);
        }
    }
}
