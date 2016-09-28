package com.example.raviraj.foodapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class SignUp extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
    }

    public void onButtonClick(View v) {

        EditText userInfo = (EditText)findViewById(R.id.Susrnm);
        String userName = userInfo.getText().toString().trim();

        EditText passwordInfo = (EditText)findViewById(R.id.Spswd);
        String password = passwordInfo.getText().toString().trim();

        final String url = "http://10.0.2.2:8080/signup" ;

        try {
            String response = new HttpPostHelper().execute(url, userName, password).get();
            if("FAIL".equals(response)) {
                Toast.makeText(getApplicationContext(), "Invalid Username or Password", Toast.LENGTH_LONG).show();


            } else {
                Toast.makeText(getApplicationContext(), "Successful", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(SignUp.this, SignIn.class);
                startActivity(intent);
            }

        } catch(Exception e) {
            e.printStackTrace();
        }

    }
}