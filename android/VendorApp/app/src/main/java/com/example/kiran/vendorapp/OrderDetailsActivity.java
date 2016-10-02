package com.example.kiran.vendorapp;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kiran on 10/2/16.
 */
public class OrderDetailsActivity extends Activity {

    private List<OrderItemDetail> orderItemDetails;

    private ListView listView;

    private TextView orderLabel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_details);
        int orderId = getIntent().getIntExtra("order_id", -1);

        listView = (ListView) findViewById(R.id.order_details_list);
        orderItemDetails = getOrderDetails(orderId);
        OrderDetailsListAdapter adapter = new OrderDetailsListAdapter(this, orderItemDetails);
        listView.setAdapter(adapter);

        orderLabel = (TextView) findViewById(R.id.order_id_label);
        orderLabel.setText("Details of Order-'"+ orderId + "'");

    }

    private List<OrderItemDetail> getOrderDetails(int orderId) {

        final List<OrderItemDetail> details = new ArrayList<>();
        final String url = "http://10.0.2.2:8080/getorderdetails/" + orderId;
        try {
            String body = new HttpGetHelper().execute(url).get();
            JSONObject json = new JSONObject(body);
            JSONArray menuArr = (JSONArray) json.get("orderdetails");

            for (int i = 0; i < menuArr.length(); i++) {
                OrderItemDetail detail = new OrderItemDetail();
                JSONObject obj = (JSONObject) menuArr.get(i);
                detail.setItemCost(obj.getInt("item_cost"));
                detail.setItemName(obj.getString("item_name"));
                details.add(detail);
            }

        } catch(Exception e) {
            e.printStackTrace();
        }
        return details;
    }

}
