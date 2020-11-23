package com.example.fbdemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class AdminActivity extends AppCompatActivity {
    DatabaseReference reference;
    RecyclerView recyclerView;
    private FirebaseRecyclerOptions<Details> options;
    private FirebaseRecyclerAdapter<Details, MyViewHolder> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);


        FirebaseDatabase database = FirebaseDatabase.getInstance();
        reference = database.getReference().child("details");
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        options = new FirebaseRecyclerOptions.Builder<Details>().setQuery(reference, Details.class).build();
        adapter = new FirebaseRecyclerAdapter<Details, MyViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull MyViewHolder holder, int position, @NonNull Details detailObj) {
                try {
                    holder.textViewName.setText(detailObj.getName());
                    holder.textViewIssue.setText(detailObj.getIssue());
                    holder.textViewDevice.setText(detailObj.getDevice());

                }
                catch (NullPointerException e){
                   // Toast.makeText(AdminActivity.this, "NullPointerExecption Occured!", Toast.LENGTH_SHORT).show();
                }

            }

            @NonNull
            @Override
            public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
               View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_item,parent,false);
                return new  MyViewHolder(view);
            }
        };

        adapter.startListening();
        recyclerView.setAdapter(adapter);


    }
}