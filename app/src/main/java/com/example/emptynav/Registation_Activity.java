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
        FirstName = (EditText)findViewById(R.id.et_fname);
        LastName = (EditText)findViewById(R.id.et_lname);
        EmailAddress = (EditText)findViewById(R.id.et_email);
        MobileNo = (EditText)findViewById(R.id.et_mobileno);
        Password = (EditText)findViewById(R.id.et_password);
        GenerateOtp = (Button) findViewById(R.id.btn_generateOtp);

        GenerateOtp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Registation_Activity.this, OTP_Activity.class);
                startActivity(intent);
            }
        });


    }
}
