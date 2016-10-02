package com.example.kiran.vendorapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by kiran on 10/1/16.
 */
public class OrderListAdapter extends ArrayAdapter<OrderItem> {


    private class ViewHolder {

        TextView orderIdTxt;
        TextView orderAmountTxt;
        TextView orderStatusTxt;
        TextView orderTimeTxt;
        TextView userNameTxt;
    }

    private LayoutInflater inflator;

    private List<OrderItem> orderItems;

    private final Context ctx;

    public OrderListAdapter(Context ctx, List<OrderItem> orderItems) {
        super(ctx, R.layout.order_element, orderItems);
        this.orderItems = orderItems;
        this.ctx = ctx;
        this.inflator = LayoutInflater.from(ctx);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final OrderItem menuItem = this.getItem(position);
        TextView orderIdTxt;
        TextView orderAmountTxt;
        TextView orderStatusTxt;
        TextView orderTimeTxt;
        TextView userNameTxt;

        if(convertView == null) {
            convertView = inflator.inflate(R.layout.order_element, null);
            orderIdTxt = (TextView) convertView.findViewById(R.id.order_id);
            orderAmountTxt= (TextView) convertView.findViewById(R.id.order_amount);
            orderStatusTxt = (TextView) convertView.findViewById(R.id.order_status);
            orderTimeTxt = (TextView) convertView.findViewById(R.id.order_time);
            userNameTxt =  (TextView) convertView.findViewById(R.id.username);

            final ViewHolder viewHolder = new ViewHolder();
            viewHolder.orderIdTxt = orderIdTxt;
            viewHolder.orderAmountTxt = orderAmountTxt;
            viewHolder.orderStatusTxt = orderStatusTxt;
            viewHolder.orderTimeTxt = orderTimeTxt;
            viewHolder.userNameTxt = userNameTxt;
            convertView.setTag(viewHolder);

        } else {
            final ViewHolder viewHolder = (ViewHolder) convertView.getTag();
            orderIdTxt = viewHolder.orderIdTxt;
            orderAmountTxt = viewHolder.orderAmountTxt;
            orderStatusTxt = viewHolder.orderStatusTxt;
            orderTimeTxt = viewHolder.orderTimeTxt;
            userNameTxt = viewHolder.userNameTxt;
        }

        orderIdTxt.setText(String.valueOf(menuItem.getOrderId()));
        orderAmountTxt.setText(String.valueOf(menuItem.getOrderAmount()));
        orderStatusTxt.setText(menuItem.getOrderStatus());
        orderTimeTxt.setText(menuItem.getDateTime());
        userNameTxt.setText(menuItem.getUserName());
        return  convertView;
    }

}
