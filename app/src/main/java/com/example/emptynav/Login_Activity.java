package com.example.emptynav;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login_Activity extends AppCompatActivity {
    TextView message;
    EditText Email;
    EditText Password;
    Button Login;
    TextView Forgotpwd;
    TextView Donthave;
    Button Register;
    InputValidation inputValidation;
    DatabaseHelper databaseHelper;
    String regexStr = "^[0-9]$";
    String regexStr1 = "\\d{3}";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initViews();
        initListeners();
        initObjects();
    }

    /* Login.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             if (Email.getText().toString().trim().length() == 0) {
                 Email.setError("Username is not entered");
                 Email.requestFocus();
             }
             if (Password.getText().toString().trim().length() == 0) {
                 Password.setError("Password is not entered");
                 Password.requestFocus();
             } else {
                 Intent intent = new Intent(Login_Activity.this, Registation_Activity.class);
                 startActivity(intent);
             }
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
     */
    private void initViews(){

        message = (TextView) findViewById(R.id.tv_message);
        Email = (EditText) findViewById(R.id.et_email);
        Password = (EditText) findViewById(R.id.et_pwd);
        Login = (Button) findViewById(R.id.btn_login);
        Forgotpwd = (TextView) findViewById(R.id.tv_forgotpwd);
        Donthave = (TextView) findViewById(R.id.tv_donthaveAc);
        Register = (Button) findViewById(R.id.btn_register);
    }

    private void initListeners() {

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verifyFromSQLite();
            }
        });
        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to RegisterActivity
                Intent intent = new Intent(getApplicationContext(), Registation_Activity.class);
                startActivity(intent);

            }
        });
    }





    /**
     * This method is to initialize objects to be used
     */
    private void initObjects() {
        databaseHelper = new DatabaseHelper(this);
        inputValidation = new InputValidation(this);
    }

    /**
     * This implemented method is to listen the click on view
     *
     * @param v
     */
          /*  @Override
            public void onClick (View v){
                switch (v.getId()) {
                    case R.id.Login:
                        verifyFromSQLite();
                        break;
                    case R.id.Register:
                        // Navigate to RegisterActivity
                        Intent intent = new Intent(getApplicationContext(), Registation_Activity.class);
                        startActivity(intent);
                        break;
                }
            }
*/
    /**
     * This method is to validate the input text fields and verify login credentials from SQLite
     */
    private void verifyFromSQLite () {
        if (Email.getText().toString().trim().length() == 0) {
            Email.setError("Username is not entered");
            Email.requestFocus();
            return;
        }
        if (Password.getText().toString().trim().length() == 0) {
            Password.setError("Password is not entered");
            Password.requestFocus();
            return;
        }

        if (databaseHelper.checkUser(Email.getText().toString().trim()
                , Password.getText().toString().trim())) {


            Intent Intent = new Intent(Login_Activity.this, MainActivity.class);
            Intent.putExtra("EMAIL", Email.getText().toString().trim());
            emptyInputEditText();
            startActivity(Intent);
            Toast.makeText(Login_Activity.this,
                    "Login Success", Toast.LENGTH_LONG).show();

        } else {
            // Snack Bar to show success message that record is wrong
            // Snackbar.make(nestedScrollView, getString(R.string.error_valid_email_password), Snackbar.LENGTH_LONG).show();

        }
    }

    /**
     * This method is to empty all input edit text
     */
    private void emptyInputEditText () {
        Email.setText(null);
        Password.setText(null);
    }
}
