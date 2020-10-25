package com.example.fbdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class HomeActivity extends AppCompatActivity {

    DatabaseReference databaseDetails;
    private EditText custName;
    private EditText custIssue;
    private Button submit;
    private Spinner spinnerDevice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        databaseDetails = database.getReference("details");

        custName = (EditText) findViewById(R.id.cname);
        custIssue = (EditText) findViewById(R.id.cissue);
        submit = (Button) findViewById(R.id.submit);
        spinnerDevice = (Spinner) findViewById(R.id.device); 
        
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addDetails();
            }
        });

    }

    private void addDetails() {
        String name = custName.getText().toString();
        String issue = custIssue.getText().toString();
        String device = spinnerDevice.getSelectedItem().toString();

        if(TextUtils.isEmpty(name) || TextUtils.isEmpty(issue)){
            Toast.makeText(this, "Enter All Details", Toast.LENGTH_SHORT).show();
        }
        else{
            String id = databaseDetails.push().getKey();
            Details custDetails = new Details(name, issue,device, id);
            databaseDetails.child(id).setValue(custDetails);
            Toast.makeText(this, "Details Added Successfully", Toast.LENGTH_SHORT).show();
        }
    }
}