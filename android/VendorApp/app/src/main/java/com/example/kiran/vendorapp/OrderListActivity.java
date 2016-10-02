package com.example.kiran.vendorapp;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class OrderListActivity extends Activity {

    private ListView listView;
    int vendorid;
    ArrayList<OrderItem> orderedItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_list);


        vendorid = getIntent().getIntExtra("vendor_id", 0);
        Toast.makeText(this, vendorid + " ", Toast.LENGTH_SHORT).show();
        OrderListAdapter adapter = new OrderListAdapter(this, getOrders(vendorid));
        listView = (ListView) findViewById(R.id.list_of_orders);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    OrderItem orderItem = (OrderItem) listView.getAdapter().getItem(position);
                    System.out.print("Order id: " + orderItem.getOrderId());
                    Intent intent = new Intent(OrderListActivity.this, OrderDetailsActivity.class);
                    intent.putExtra("order_id", orderItem.getOrderId());
                    startActivity(intent);
            }
        });
    }

    public List<OrderItem> getOrders(int vendorid) {
        final List<OrderItem> orderedItems = new ArrayList<>();
        final String url = "http://10.0.2.2:8080/showorders/" + vendorid;
        try {
            String body = new HttpGetHelper().execute(url).get();
            JSONObject json = new JSONObject(body);
            JSONArray menuArr = (JSONArray) json.get("order");

            for (int i = 0; i < menuArr.length(); i++) {
                int orderId = menuArr.getJSONObject(i).getInt("orderid");
                int restaurantId = menuArr.getJSONObject(i).getInt("R_ID");
                int userId = menuArr.getJSONObject(i).getInt("u_id");
                String userName = menuArr.getJSONObject(i).getString("u_name");
                int total = menuArr.getJSONObject(i).getInt("total");
                String time = menuArr.getJSONObject(i).getString("time");
                String status = menuArr.getJSONObject(i).getString("status");


                OrderItem orderItem = new OrderItem();
                //orderItem.setItemId(itemId);
                orderItem.setUserName(userName);
                orderItem.setOrderId(orderId);
                orderItem.setDateTime(time);
                orderItem.setOrderStatus(status);
                orderItem.setOrderAmount(total);
                orderedItems.add(orderItem);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return orderedItems;
    }

}
