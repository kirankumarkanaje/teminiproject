package com.example.raviraj.foodapp;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ConfirmOrderActivity extends Activity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.confirm_order);

        // Get ordered items from bundle
        Bundle bundle = getIntent().getExtras();
        ArrayList<MenuItem> orderedItems = bundle.getParcelableArrayList("order_items");
        final ConfirmOrderMenuListAdapter menuList = new ConfirmOrderMenuListAdapter(this, orderedItems);
        listView = (ListView)findViewById(R.id.confirm_list);
        listView.setAdapter(menuList);

        setTotalAmount(orderedItems);
    }

    private void setTotalAmount(ArrayList<MenuItem> orderedItems) {
        int totalAmount = 0;
        for (MenuItem menuItem: orderedItems) {
            totalAmount += menuItem.getItemCost();
        }
        TextView totalAmountTxtView = (TextView)findViewById(R.id.id_total_amt);
        totalAmountTxtView.setText(String.valueOf(totalAmount));
    }

    public void confirmOrder(View v) {
        // TODO: Make post call to save the order, items, userid, restaurantid
        Toast.makeText(this, "TBD: making post call to save order", Toast.LENGTH_SHORT).show();
    }

}
