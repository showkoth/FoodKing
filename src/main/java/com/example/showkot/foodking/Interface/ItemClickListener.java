package com.example.showkot.foodking.Interface;

import android.view.View;



public interface ItemClickListener { // interface for strategy pattern

    // this method to override in Home, FoodList
    void onClick(View view, int position, boolean isLongClick);
}
