package com.theeditorstudio.ordermanager.utils.searchs;

import com.theeditorstudio.ordermanager.OrderManager;
import com.theeditorstudio.ordermanager.models.OrderModel;

import java.util.ArrayList;

public class FindOrderByName {

    public static ArrayList<OrderModel> getOrders(String fname, String lname){
        ArrayList<OrderModel> orders = new ArrayList<>();
        for (OrderModel order : OrderManager.orderModelArrayList){
            if(order.getFirstName().equals(fname) && order.getLastName().equals(lname)){
                orders.add(order);
            }
        }
        return orders;
    }
}
