package com.example.emptynav;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Registation_Activity extends AppCompatActivity {
    EditText FirstName;
    EditText LastName;
    EditText EmailAddress;
    EditText MobileNo;
    EditText Password;
    Button GenerateOtp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registation_);
        FirstName = (EditText) findViewById(R.id.et_fname);
        LastName = (EditText) findViewById(R.id.et_lname);
        EmailAddress = (EditText) findViewById(R.id.et_email);
        MobileNo = (EditText) findViewById(R.id.et_mobileno);
        Password = (EditText) findViewById(R.id.et_password);
        GenerateOtp = (Button) findViewById(R.id.btn_generateOtp);

        GenerateOtp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (FirstName.getText().toString().trim().length() == 0) {
                    FirstName.setError("Username is not entered");
                    FirstName.requestFocus();
                }
                if (Password.getText().toString().trim().length() == 0) {
                    Password.setError("Password is not entered");
                    Password.requestFocus();
                }
                if (LastName.getText().toString().trim().length() == 0) {
                    LastName.setError("Username is not entered");
                    LastName.requestFocus();
                }
                if (MobileNo.getText().toString().trim().length() == 0) {
                    MobileNo.setError("Password is not entered");
                    MobileNo.requestFocus();
                   // if (EmailAddress.getText().toString().trim().length() == 0) {
                       // EmailAddress.setError("Password is not entered");
                       // EmailAddress.requestFocus();
                    } else {
                        Intent intent = new Intent(Registation_Activity.this, OTP_Activity.class);
                        startActivity(intent);
                    }
                }
           // }
        });
    }
    }

