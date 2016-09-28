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


public class MenuListAdapter extends ArrayAdapter<MenuItem> implements AdapterView.OnItemClickListener {

    private class ViewHolder {
        TextView itemNameTxt;
        TextView itemCostTxt;
        CheckBox isSelected;
        TextView itemIdTxt;
    }

    private  LayoutInflater inflator;

    private List<MenuItem> menuItems;

    private final Context ctx;

    public MenuListAdapter(Context ctx, List<MenuItem> menuItems) {
        super(ctx, R.layout.list_element, menuItems);
        this.menuItems = menuItems;
        this.ctx = ctx;
        this.inflator = LayoutInflater.from(ctx);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        MenuItem menuItem = this.getItem(position);
        menuItem.setIsSelected(!menuItem.isSelected());
        ViewHolder holder = (ViewHolder) view.getTag();
        holder.isSelected.setChecked(menuItem.isSelected());
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        MenuItem menuItem = this.getItem(position);

        TextView menuItemTxt ;
        TextView menuCostTxt;
        CheckBox isSelectedChk;
        TextView itemIdTxt;

        if(convertView == null) {
            convertView = inflator.inflate(R.layout.list_element, null);
            menuItemTxt = (TextView) convertView.findViewById(R.id.item_name);
            menuCostTxt = (TextView) convertView.findViewById(R.id.item_cost);
            isSelectedChk = (CheckBox) convertView.findViewById(R.id.is_selected);
            itemIdTxt = (TextView) convertView.findViewById(R.id.item_id);

            ViewHolder viewHolder = new ViewHolder();
            viewHolder.itemNameTxt = menuItemTxt;
            viewHolder.itemCostTxt = menuCostTxt;
            viewHolder.isSelected = isSelectedChk;
            viewHolder.itemIdTxt = itemIdTxt;
            convertView.setTag(viewHolder);

            isSelectedChk.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    CheckBox chkBx = (CheckBox) v;
                    MenuItem menuItem = (MenuItem) chkBx.getTag();
                    menuItem.setIsSelected(chkBx.isChecked());
                }
            });
        } else {
            ViewHolder viewHolder = (ViewHolder) convertView.getTag();
            menuItemTxt = viewHolder.itemNameTxt;
            menuCostTxt = viewHolder.itemCostTxt;
            isSelectedChk = viewHolder.isSelected;
            itemIdTxt = viewHolder.itemIdTxt;
        }

        isSelectedChk.setTag(menuItem);
        menuItemTxt.setText(menuItem.getItemName());
        menuCostTxt.setText(String.valueOf(menuItem.getItemCost()));
        isSelectedChk.setSelected(menuItem.isSelected());
        itemIdTxt.setText(menuItem.getItemId());

        return  convertView;
    }
}
