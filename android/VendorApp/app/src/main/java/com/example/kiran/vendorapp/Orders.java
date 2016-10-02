package com.example.kiran.vendorapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Orders extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.orders);
    }

    public void getAllOrders(View v){
        Toast.makeText(this, ((Button)v).getText(), Toast.LENGTH_LONG).show();
        Intent intent = new Intent(Orders.this, OrderListActivity.class);
        startActivity(intent);

    }

    public void getPendingOrders(View v){
        Toast.makeText(this, ((Button)v).getText(), Toast.LENGTH_LONG).show();
        Intent intent = new Intent(Orders.this, OrderListActivity.class);
        startActivity(intent);

    }

    public void getOrdersUp(View v){
        Toast.makeText(this, ((Button)v).getText(), Toast.LENGTH_LONG).show();
        Intent intent = new Intent(Orders.this, OrderListActivity.class);
        startActivity(intent);

    }

    public void getTakeOrders(View v){
        Toast.makeText(this, ((Button)v).getText(), Toast.LENGTH_LONG).show();
        Intent intent = new Intent(Orders.this, OrderListActivity.class);
        startActivity(intent);

    }

}