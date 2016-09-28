package com.example.raviraj.foodapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class Registration extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration);
    }

    public void getSignup(View v) {
        Toast.makeText(this, ((Button) v).getText(), Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(Registration.this, SignUp.class);
        startActivity(intent);


    }

    public void getSignin(View v) {
        Toast.makeText(this, ((Button) v).getText(), Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(Registration.this, SignIn.class);
        startActivity(intent);
    }
}