package com.example.raviraj.foodapp;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class LastPage extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.last_page);

        //one more get rest call
    }

    public void getHome(View v){
        Toast.makeText(this, ((Button) v).getText(), Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(LastPage.this,MainPage.class);
        startActivity(intent);


    }
}
