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

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.ViewHolder> {

    Context context;
    ArrayList<Student> list;
    ItemClickListener listener;

    public interface ItemClickListener {
        void onItemClick(int position);
        void onDeleteClick(int position);
    }

    public StudentAdapter(Context context, ArrayList<Student> list, ItemClickListener listener) {
        this.context = context;
        this.list = list;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_student, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Student s = list.get(position);
        holder.txtName.setText(s.name);
        holder.txtMssv.setText(s.mssv);

        holder.itemView.setOnClickListener(v ->
                listener.onItemClick(position)
        );

        holder.btnDelete.setOnClickListener(v ->
                listener.onDeleteClick(position)
        );
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtName, txtMssv;
        ImageView btnDelete;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.txtName);
            txtMssv = itemView.findViewById(R.id.txtMssv);
            btnDelete = itemView.findViewById(R.id.btnDelete);
        }
    }
}
