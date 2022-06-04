package com.biet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void signup(View view) {
        EditText userNameEditText = findViewById(R.id.userName);
        EditText pwdEditText = findViewById(R.id.password);
        String userName = userNameEditText.getText().toString();
        String pwd = pwdEditText.getText().toString();
        boolean isPasswordValid = PasswordUtil.validatePassword(pwd);
        if(userName.trim().isEmpty())
        {
            Toast.makeText(this, "User name can't be empty", Toast.LENGTH_SHORT).show();
        }
        if(!isPasswordValid){
            Toast.makeText(this, R.string.pwd_msg, Toast.LENGTH_LONG).show();
        }
        else{
            //Clear edit text
            userNameEditText.setText("");
            pwdEditText.setText("");

            //Go to Login Activity
            Intent i = new Intent(this,LoginActivity.class);
            i.putExtra("USER_NAME",userName);
            i.putExtra("PWD" , pwd);
            startActivity(i);
        }

    }

}