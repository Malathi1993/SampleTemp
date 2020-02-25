package com.example.emptynav;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class OTP_Activity extends AppCompatActivity {
TextView OtpText;
EditText EnterOtp;
Button Login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp_);
         OtpText =(TextView)findViewById(R.id.tv_otpmsg);
         EnterOtp =(EditText) findViewById(R.id.et_enterOtp);
         Login =(Button) findViewById(R.id.btn_otp_login);

         Login.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent intent = new Intent(OTP_Activity.this, MainActivity.class);
                 startActivity(intent);
             }
         });
    }
}
