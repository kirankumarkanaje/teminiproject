package com.example.raviraj.foodapp;

import android.app.Activity;
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
public class Activity2 extends Activity {
    List<String> menuitems = new ArrayList<>();
    ArrayAdapter<String> adapter;

    private ListView kListView;

    private Map<String, Integer> menuNameToId = new HashMap<>();

    int clickCounter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2);

        kListView = (ListView) findViewById(R.id.listItems);
        kListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String entry = (String) parent.getAdapter().getItem(position);

            }
        });

        int restaurantId = getIntent().getIntExtra("restaurant_id", 0);
        menuitems = getMenu(restaurantId);



        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, menuitems);
        kListView.setAdapter(adapter);

    }

    public List<String> getMenu(int restaurantId) {
        final List<String> itemNames = new ArrayList<>();
        final String url = "http://10.0.2.2:8080/menu/" + restaurantId;
        try {
            String body = new HttpGetHelper().execute(url).get();
            JSONObject json = new JSONObject(body);
            JSONArray menuArr = (JSONArray) json.get("menu");
            for (int i = 0; i < menuArr.length(); i++) {
                itemNames.add(menuArr.getJSONObject(i).getString("iname"));
                //menuNameToId.put(menuArr.getJSONObject(i).getString("iname"), menuArr.getJSONObject(i).getInt("iid"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return itemNames;
    }


}

