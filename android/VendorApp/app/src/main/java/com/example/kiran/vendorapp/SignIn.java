package com.example.kiran.vendorapp;
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

        final String url = "http://10.0.2.2:8080/vsignin" ;

        try {
            String body = new HttpPostHelper().execute(url, userName, password).get();
            Toast.makeText(getApplicationContext(), body, Toast.LENGTH_LONG).show();
            JSONObject json = new JSONObject(body);
            String response = json.getString("status");
            String vendorid = json.getString("vendor_id");

            if("FAIL".equals(response)) {
                Toast.makeText(getApplicationContext(), "Invalid Username or Password", Toast.LENGTH_LONG).show();


            } else {
                Toast.makeText(getApplicationContext(), "Successful", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(SignIn.this, OrderListActivity.class);
                intent.putExtra("vendor_id", Integer.parseInt(vendorid));
                //Toast.makeText(this, json.toString(), Toast.LENGTH_LONG).show();
                startActivity(intent);
            }

        } catch(Exception e) {
            e.printStackTrace();
        }

    }
}