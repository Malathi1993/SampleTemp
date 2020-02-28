package com.example.emptynav;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Registation_Activity extends AppCompatActivity implements View.OnClickListener {
    EditText FirstName;
    EditText LastName;
    EditText EmailAddress;
    EditText MobileNo;
    EditText Password;
    Button GenerateOtp;
    InputValidation inputValidation;
    DatabaseHelper databaseHelper;
    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registation);
        initViews();
        initListeners();
        initObjects();
    }

    /* GenerateOtp.setOnClickListener(new View.OnClickListener() {
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
*/
    private void initViews() {

        FirstName = (EditText) findViewById(R.id.et_fname);
        LastName = (EditText) findViewById(R.id.et_lname);
        EmailAddress = (EditText) findViewById(R.id.et_eAddress);
        MobileNo = (EditText) findViewById(R.id.et_mobileno);
        Password = (EditText) findViewById(R.id.et_password);
        GenerateOtp = (Button) findViewById(R.id.btn_generateOtp);
    }

    private void initListeners() {
        GenerateOtp.setOnClickListener((View.OnClickListener) this);
        // appCompatTextViewLoginLink.setOnClickListener(this);

    }

    /**
     * This method is to initialize objects to be used
     */
    private void initObjects() {
        inputValidation = new InputValidation(this);
        databaseHelper = new DatabaseHelper(this);
        user = new User();

    }


    /**
     * This implemented method is to listen the click on view
     *
     * @param v
     */
    @Override
    public void onClick (View v){
        switch (v.getId()) {

            case R.id.btn_generateOtp:
                postDataToSQLite();
                break;

               /* case R.id.btn_login:
                    finish();
                    break;*/
        }
    }

    /**
     * This method is to validate the input text fields and post data to SQLite
     */
    private void postDataToSQLite () {
           /* if (!inputValidation.isInputEditTextFilled(Name, Name, getString(R.string.error_message_name))) {
                return;
            }
            if (!inputValidation.isInputEditTextFilled(Email, Email, getString(R.string.error_message_email))) {
                return;
            }*/
        //  if (!inputValidation.isInputEditTextEmail(Email, Email, getString(R.string.error_message_email))) {
        //  return;
        //  }
           /* if (!inputValidation.isInputEditTextFilled(Password, Password, getString(R.string.error_message_password))) {
                return;
            }*/
        // if (!inputValidation.isInputEditTextMatches(Password, ConfirmPassword,
        //  ConfirmPassword, getString(R.string.error_password_match))) {
        // return;
        //  }

        if (!databaseHelper.checkUser(EmailAddress.getText().toString().trim())) {

            user.setName(FirstName.getText().toString().trim());
            user.setEmail(EmailAddress.getText().toString().trim());
            user.setPassword(Password.getText().toString().trim());
            user.setPhone(MobileNo.getText().toString().trim());

            databaseHelper.addUser(user);

            // Snack Bar to show success message that record saved successfully
            // Snackbar.make(nestedScrollView, getString(R.string.success_message), Snackbar.LENGTH_LONG).show();
            emptyInputEditText();
            Intent intent = new Intent(this, MainActivity.class);
            Bundle bundle = new Bundle();
            bundle.putParcelable("user", user);
            intent.putExtras(bundle);
            startActivity(intent);
            Toast.makeText(Registation_Activity.this,
                    "Registation Success", Toast.LENGTH_LONG).show();

        } else {
            // Snack Bar to show error message that record already exists
            //Snackbar.make(nestedScrollView, getString(R.string.error_email_exists), Snackbar.LENGTH_LONG).show();
        }


    }

    /**
     * This method is to empty all input edit text
     */
    private void emptyInputEditText () {
        FirstName.setText(null);
        EmailAddress.setText(null);
        Password.setText(null);
        MobileNo.setText(null);
        // ConfirmPassword.setText(null);
    }
}