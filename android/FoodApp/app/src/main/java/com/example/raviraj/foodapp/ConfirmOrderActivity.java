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

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class ConfirmOrderActivity extends Activity {

    private ListView listView;

    String userid;

    int restaurantId;

    int totalAmount = 0;

    ArrayList<MenuItem> orderedItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.confirm_order);

        // Get ordered items from bundle
        Bundle bundle = getIntent().getExtras();
        orderedItems = bundle.getParcelableArrayList("order_items");
        userid = bundle.getString("user_id");
        restaurantId = bundle.getInt("restaurant_id");



        final ConfirmOrderMenuListAdapter menuList = new ConfirmOrderMenuListAdapter(this, orderedItems);
        listView = (ListView)findViewById(R.id.confirm_list);
        listView.setAdapter(menuList);

        setTotalAmount(orderedItems);
    }

    private void setTotalAmount(ArrayList<MenuItem> orderedItems) {

        for (MenuItem menuItem: orderedItems) {
            totalAmount += menuItem.getItemCost();
        }
        TextView totalAmountTxtView = (TextView)findViewById(R.id.id_total_amt);
        totalAmountTxtView.setText(String.valueOf(totalAmount));
    }

    public void confirmOrder(View v) {
        final JSONObject orderJson = new JSONObject();
        try {
            orderJson.put("restaurant_id", restaurantId);
            orderJson.put("user_id", Integer.parseInt(userid));
            orderJson.put("total_amount", totalAmount);
            JSONArray itemIds = new JSONArray();
            for (MenuItem item : orderedItems) {
                itemIds.put(Integer.parseInt(item.getItemId()));
            }
            orderJson.put("item_ids", itemIds);
        } catch(Exception e) {
            e.printStackTrace();
        }

        // make post call
        Toast.makeText(this, orderJson.toString(), Toast.LENGTH_LONG).show();
        final String url = "http://10.0.2.2:8080/placeorder" ;

        try {
            new OrderHttpPostHelper().execute(url, orderJson.toString()).get();
        } catch(Exception e) {
            e.printStackTrace();
        }

    }

}
