package com.example.raviraj.foodapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class ConfirmBillingAdapter extends ArrayAdapter<MenuItem> implements AdapterView.OnItemClickListener {

    private class ViewHolder {
        TextView billingitemNameTxt;
        TextView billingitemCostTxt;
        TextView billingitemIdTxt;
    }

    private LayoutInflater inflator;

    private List<MenuItem> billingmenuItems;

    private final Context context;

    public ConfirmBillingAdapter(Context context, List<MenuItem> billingmenuItems) {
        super(context, R.layout.billing_element, billingmenuItems);
        this.billingmenuItems = billingmenuItems;
        this.context = context;
        this.inflator = LayoutInflater.from(context);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        MenuItem billingmenuItem = this.getItem(position);
        ViewHolder holder = (ViewHolder) view.getTag();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        MenuItem billingmenuItem = this.getItem(position);
        TextView billingmenuItemTxt ;
        TextView billingmenuCostTxt;
        TextView billingitemIdTxt;

        if(convertView == null) {
            convertView = inflator.inflate(R.layout.billing_element, null);
            billingmenuItemTxt = (TextView) convertView.findViewById(R.id.billing_iname);
            billingmenuCostTxt = (TextView) convertView.findViewById(R.id.billing_icost);
            billingitemIdTxt = (TextView) convertView.findViewById(R.id.billing_id);

            ViewHolder viewHolder = new ViewHolder();
            viewHolder.billingitemNameTxt = billingmenuItemTxt;
            viewHolder.billingitemCostTxt = billingmenuCostTxt;
            viewHolder.billingitemIdTxt = billingitemIdTxt;
            convertView.setTag(viewHolder);
        } else {
            ViewHolder viewHolder = (ViewHolder) convertView.getTag();
            billingmenuItemTxt = viewHolder.billingitemNameTxt;
            billingmenuCostTxt = viewHolder.billingitemCostTxt;
            billingitemIdTxt = viewHolder.billingitemIdTxt;
        }

        billingmenuItemTxt.setText(billingmenuItem.getItemName());
        billingmenuCostTxt.setText(String.valueOf(billingmenuItem.getItemCost()));
        billingitemIdTxt.setText(billingmenuItem.getItemId());

        return  convertView;
    }


}
