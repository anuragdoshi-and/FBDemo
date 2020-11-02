package com.example.fbdemo;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder extends RecyclerView.ViewHolder {

    public TextView textViewName, textViewIssue, textViewDevice;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);

        textViewName = itemView.findViewById(R.id.custName);
        textViewIssue = itemView.findViewById(R.id.custDevice);
        textViewIssue  = itemView.findViewById(R.id.custIssue);

    }
}
