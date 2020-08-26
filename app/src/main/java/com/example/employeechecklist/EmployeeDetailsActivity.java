package com.example.employeechecklist;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDetailsActivity extends AppCompatActivity {

    ImageView imgProfile;
    TextView txtEmployeeName;
    TextView txtEmployeeUsername;
    TextView txtEmail;
    TextView txtAddress;
    TextView txtPhone;
    TextView txtWebsite;
    TextView txtCompanyDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Intent intent = getIntent();
        Bundle position = intent.getExtras();

        imgProfile = findViewById(R.id.imgProfile);
        txtEmployeeName = findViewById(R.id.employeeName);
        txtEmployeeUsername = findViewById(R.id.employeeUserName);
        txtEmail = findViewById(R.id.employeeEmail);
        txtAddress = findViewById(R.id.employeeAddress);
        txtPhone = findViewById(R.id.employeePhone);
        txtWebsite = findViewById(R.id.employeeWebsite);
        txtCompanyDetails = findViewById(R.id.employeeCompanyDetails);

    }
}
