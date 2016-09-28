package com.example.raviraj.foodapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainPage extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainpage);
    }

    public void getMenu(View v){
        Toast.makeText(this, ((Button)v).getText(), Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(MainPage.this,Activity1.class);
        intent.putExtra("click_type", ((Button)v).getText());
        startActivity(intent);
    }
}
