package com.example.emptynav;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Login_Activity extends AppCompatActivity {
TextView message;
EditText Email;
EditText Password;
Button Login;
TextView Forgotpwd;
TextView Donthave;
Button Register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_);
        message = (TextView)findViewById(R.id.tv_message);
        Email = (EditText) findViewById(R.id.et_email);
        Password = (EditText) findViewById(R.id.et_pwd);
        Login = (Button) findViewById(R.id.btn_login);
        Forgotpwd = (TextView)findViewById(R.id.tv_forgotpwd);
        Donthave = (TextView)findViewById(R.id.tv_donthaveAc);
        Register= (Button) findViewById(R.id.btn_register);


        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login_Activity.this, OTP_Activity.class);
                startActivity(intent);
            }
        });


        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login_Activity.this, Registation_Activity.class);
                startActivity(intent);
            }
        });

    }
}
