package com.example.kiran.vendorapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by kiran on 10/2/16.
 */
public class OrderDetailsListAdapter extends ArrayAdapter<OrderItemDetail> {

    private class ViewHolder {
        TextView itemNameTxt;
        TextView itemCostTxt;
    }

    private LayoutInflater inflator;

    private List<OrderItemDetail> orderItems;

    private final Context ctx;

    public OrderDetailsListAdapter(Context ctx, List<OrderItemDetail> orderItemDetails) {
        super(ctx, R.layout.order_details_element, orderItemDetails);
        this.orderItems = orderItems;
        this.ctx = ctx;
        this.inflator = LayoutInflater.from(ctx);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final OrderItemDetail orderDetail = this.getItem(position);
        TextView itemNameTxt;
        TextView itemCostTxt;

        if(convertView == null) {
            convertView = inflator.inflate(R.layout.order_details_element, null);
            itemNameTxt = (TextView) convertView.findViewById(R.id.d_item_name);
            itemCostTxt= (TextView) convertView.findViewById(R.id.d_item_cost);

            final ViewHolder viewHolder = new ViewHolder();
            viewHolder.itemNameTxt = itemNameTxt;
            viewHolder.itemCostTxt = itemCostTxt;
            convertView.setTag(viewHolder);
        } else {
            final ViewHolder viewHolder = (ViewHolder) convertView.getTag();
            itemNameTxt = viewHolder.itemNameTxt;
            itemCostTxt = viewHolder.itemCostTxt;
        }

        itemNameTxt.setText(String.valueOf(orderDetail.getItemName()));
        itemCostTxt.setText(String.valueOf(orderDetail.getItemCost()));
        return  convertView;
    }
}
