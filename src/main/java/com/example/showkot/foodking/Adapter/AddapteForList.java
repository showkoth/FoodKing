package com.example.showkot.foodking.Adapter;

import com.example.showkot.foodking.Model.Order;

import java.util.List;

public class AddapteForList { /// Addapter pattern to use List as Array /// Pattern used in CartAdapter


public Order[] convert(List<Order> listData){ // method to convert list into array
    Order[] order = new Order[listData.size()];
    for(int i = 0; i<listData.size(); i++){
        order[i] = listData.get(i);
    }
    return order;

}

}
