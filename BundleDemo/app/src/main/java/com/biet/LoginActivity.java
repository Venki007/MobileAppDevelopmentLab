package com.biet;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private int attemptCount = 0;
    private static final int ATTEMPT_LIMIT = 3;
    private String sUserName = "";
    private String sPassword = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        attemptCount = 0;
        Bundle extras = getIntent().getExtras();
        sUserName = extras.getString("USER_NAME");
        sPassword = extras.getString("PWD");
    }

    public void login(View view) {
        attemptCount++;
        if(attemptCount >= ATTEMPT_LIMIT){
            // Go back to signup activity
            Toast.makeText(this, "You have exhausted max attempts", Toast.LENGTH_LONG).show();
            onBackPressed();
        }
        else{
            EditText userNameEditText = findViewById(R.id.lUserName);
            EditText pwdEditText = findViewById(R.id.lPassword);
            String userName = userNameEditText.getText().toString().trim();
            String pwd = pwdEditText.getText().toString().trim();
            if(PasswordUtil.validatePassword(pwd) && userName.equals(sUserName) && pwd.equals(sPassword) ){
                Toast.makeText(this, "LOGIN SUCCESSFUL", Toast.LENGTH_SHORT).show();
                attemptCount = 0;
            }
            else {
                Toast.makeText(this, "Invalid Credentials, "+ (ATTEMPT_LIMIT - attemptCount) + " attempts left", Toast.LENGTH_SHORT).show();
            }

        }

    }
}