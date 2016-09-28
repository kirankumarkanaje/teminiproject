package com.example.raviraj.foodapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RestaurantListActivity extends AppCompatActivity {
    List<String> listItems = new ArrayList<String>();
    ArrayAdapter<String> adapter;

    private ListView mListView;

    private Map<String, Integer> restaurantNameToId = new HashMap<>();

    int clickCounter = 0;

    String userid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);

        userid=  getIntent().getStringExtra("user_id");

        mListView = (ListView) findViewById(R.id.listItems);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String entry= (String) parent.getAdapter().getItem(position);
                getMenu(entry);
            }
        });

        String restaurantType = getIntent().getStringExtra("click_type");
        listItems = getRestaurants(restaurantType);

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listItems);
        mListView.setAdapter(adapter);


    }

    public List<String> getRestaurants(String restaurantType) {
        final List<String> restaurantNames = new ArrayList<>();
        final String url = "http://10.0.2.2:8080/restaurants/" + restaurantType;
        try {
            String body = new HttpGetHelper().execute(url).get();
            JSONObject json = new JSONObject(body);
            JSONArray restaurantsArr = (JSONArray) json.get("restaurants");
            for (int i = 0; i < restaurantsArr.length(); i++) {
                restaurantNames.add(restaurantsArr.getJSONObject(i).getString("name"));
                restaurantNameToId.put(restaurantsArr.getJSONObject(i).getString("name"), restaurantsArr.getJSONObject(i).getInt("id"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return restaurantNames;
    }

    public void getMenu(String restaurantName) {
        int id = restaurantNameToId.get(restaurantName);
        Intent intent = new Intent(RestaurantListActivity.this, MenuListActivity.class);
        intent.putExtra("restaurant_id", id);
        intent.putExtra("user_id", userid);
        startActivity(intent);
    }

}