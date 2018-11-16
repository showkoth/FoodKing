package com.example.showkot.foodking.Iterator;

import com.example.showkot.foodking.Model.Order;

import java.util.ArrayList;

public class CartClass {
    ArrayList<Order> orders= new ArrayList<>();
    int pos;

    public CartClass() {
        pos= 0;
    }

    public void addCart(Order e){
        orders.add(e);
    }

    public Iterators getIterator(){
        return new CartIterators();
    }

    private class CartIterators implements Iterators {


        @Override
        public boolean hasNext() {
            return pos<orders.size();
        }

        @Override
        public Object Next() {
            return orders.get(pos++);
        }
    }
}
