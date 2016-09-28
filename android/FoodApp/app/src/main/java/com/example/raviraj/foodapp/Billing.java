package com.example.raviraj.foodapp;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class Billing extends Activity {

    private ListView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.billing);

        Bundle bundle = getIntent().getExtras();
        ArrayList<MenuItem> orderedItems = bundle.getParcelableArrayList("order_items");
        final ConfirmBillingAdapter menuList = new ConfirmBillingAdapter(this, orderedItems);
        listview = (ListView)findViewById(R.id.confirm_bill);
        listview.setAdapter(menuList);

    }
}
