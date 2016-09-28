package com.example.raviraj.foodapp;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by raviraj on 25/9/16.
 */
public class MenuItem implements Parcelable {

    private String itemName;

    private int itemCost;

    private boolean isSelected;

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    private String itemId;

    public MenuItem(String itemName, int itemCost, boolean isSelected) {
        this.itemName = itemName;
        this.itemCost = itemCost;
        this.isSelected = isSelected;
    }

    public MenuItem withId(String id) {
        this.itemId = id;
        return this;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getItemCost() {
        return itemCost;
    }

    public void setItemCost(int itemCost) {
        this.itemCost = itemCost;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setIsSelected(boolean isSelected) {
        this.isSelected = isSelected;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(itemName);
        dest.writeInt(itemCost);
        dest.writeString(itemId);
    }

   public MenuItem(Parcel in) {
       this.itemName = in.readString();
       this.itemCost = in.readInt();
       this.itemId = in.readString();
   }

    public static final Parcelable.Creator<MenuItem> CREATOR = new Parcelable.Creator<MenuItem>()
    {
        public MenuItem createFromParcel(Parcel in)
        {
            return new MenuItem(in);
        }
        public MenuItem[] newArray(int size)
        {
            return new MenuItem[size];
        }
    };
}
