package com.example.raviraj.foodapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class MenuListActivity extends Activity {

    private ListView listView;
    int restaurantId;

    String userid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2);
        userid = getIntent().getStringExtra("user_id");
        restaurantId = getIntent().getIntExtra("restaurant_id", 0);
        final MenuListAdapter menuList = new MenuListAdapter(this, getMenu(restaurantId));
        listView = (ListView)findViewById(R.id.listItems);
        listView.setAdapter(menuList);

    }

    public List<MenuItem> getMenu(int restaurantId) {
        final List<MenuItem> itemNames = new ArrayList<>();
        final String url = "http://10.0.2.2:8080/menu/" + restaurantId;
        try {
            String body = new HttpGetHelper().execute(url).get();
            JSONObject json = new JSONObject(body);
            JSONArray menuArr = (JSONArray) json.get("menu");
            for (int i = 0; i < menuArr.length(); i++) {
                String itemName = menuArr.getJSONObject(i).getString("iname");
                int itemCost= menuArr.getJSONObject(i).getInt("iprice");
                String itemId = menuArr.getJSONObject(i).getString("iid");
                itemNames.add(new MenuItem(itemName, itemCost, false).withId(itemId));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return itemNames;
    }

    public void placeOrder(View view) {
        final ArrayList<MenuItem> selectedItems = new ArrayList<>();
        for(int i=0; i< listView.getCount(); i++) {
            View lview = listView.getChildAt(i);
            if (null != lview) {
                boolean isSelected = ((CheckBox) lview.findViewById(R.id.is_selected)).isChecked();
                if (isSelected) {
                    String itemName = String.valueOf(((TextView) lview.findViewById(R.id.item_name)).getText());
                    int itemCost = Integer.valueOf(String.valueOf(((TextView) lview.findViewById(R.id.item_cost)).getText()));
                    boolean isChecked = ((CheckBox) lview.findViewById(R.id.is_selected)).isChecked();
                    String itemId = String.valueOf(((TextView) lview.findViewById(R.id.item_id)).getText());
                    selectedItems.add(new MenuItem(itemName, itemCost, isChecked).withId(itemId));
                }
            }
        }
        // Goto next page
        Intent intent = new Intent(MenuListActivity.this, ConfirmOrderActivity.class);
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("order_items", selectedItems);
        bundle.putString("user_id", userid);
        bundle.putInt("restaurant_id", restaurantId);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
