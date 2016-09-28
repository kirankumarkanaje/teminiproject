package com.example.raviraj.foodapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONObject;


public class SignIn extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signin);
    }

    public void onButtonClick(View v) {

        EditText userInfo = (EditText)findViewById(R.id.TFusrnm);
        String userName = userInfo.getText().toString().trim();

        EditText passwordInfo = (EditText)findViewById(R.id.pswd);
        String password = passwordInfo.getText().toString().trim();

        final String url = "http://10.0.2.2:8080/login" ;

        try {
            String body = new HttpPostHelper().execute(url, userName, password).get();
            JSONObject json = new JSONObject(body);
            String response = json.getString("status");
            String userid = json.getString("user_id");

            if("FAIL".equals(response)) {
                Toast.makeText(getApplicationContext(), "Invalid Username or Password", Toast.LENGTH_LONG).show();


            } else {
                Toast.makeText(getApplicationContext(), "Successful", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(SignIn.this, MainPage.class);

                intent.putExtra("user_id", userid);

                startActivity(intent);
            }

        } catch(Exception e) {
            e.printStackTrace();
        }

    }
}