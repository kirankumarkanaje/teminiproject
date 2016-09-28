package com.example.raviraj.foodapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.List;

public class ConfirmOrderMenuListAdapter extends ArrayAdapter<MenuItem> implements AdapterView.OnItemClickListener {

    private class ViewHolder {
        TextView itemNameTxt;
        TextView itemCostTxt;
        TextView itemIdTxt;
    }

    private LayoutInflater inflator;

    private List<MenuItem> menuItems;

    private final Context ctx;

    public ConfirmOrderMenuListAdapter(Context ctx, List<MenuItem> menuItems) {
        super(ctx, R.layout.confirm_element, menuItems);
        this.menuItems = menuItems;
        this.ctx = ctx;
        this.inflator = LayoutInflater.from(ctx);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        MenuItem menuItem = this.getItem(position);
        ViewHolder holder = (ViewHolder) view.getTag();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        MenuItem menuItem = this.getItem(position);
        TextView menuItemTxt ;
        TextView menuCostTxt;
        TextView itemIdTxt;

        if(convertView == null) {
            convertView = inflator.inflate(R.layout.confirm_element, null);
            menuItemTxt = (TextView) convertView.findViewById(R.id.c_item_name);
            menuCostTxt = (TextView) convertView.findViewById(R.id.c_item_cost);
            itemIdTxt = (TextView) convertView.findViewById(R.id.c_item_id);

            ViewHolder viewHolder = new ViewHolder();
            viewHolder.itemNameTxt = menuItemTxt;
            viewHolder.itemCostTxt = menuCostTxt;
            viewHolder.itemIdTxt = itemIdTxt;
            convertView.setTag(viewHolder);
        } else {
            ViewHolder viewHolder = (ViewHolder) convertView.getTag();
            menuItemTxt = viewHolder.itemNameTxt;
            menuCostTxt = viewHolder.itemCostTxt;
            itemIdTxt = viewHolder.itemIdTxt;
        }

        menuItemTxt.setText(menuItem.getItemName());
        menuCostTxt.setText(String.valueOf(menuItem.getItemCost()));
        itemIdTxt.setText(menuItem.getItemId());

        return  convertView;
    }
}
