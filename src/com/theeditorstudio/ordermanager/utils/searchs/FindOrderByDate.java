package com.theeditorstudio.ordermanager.utils.searchs;

import com.theeditorstudio.ordermanager.OrderManager;
import com.theeditorstudio.ordermanager.models.OrderModel;

import java.time.LocalDate;
import java.util.ArrayList;

public class FindOrderByDate {

    public static ArrayList<OrderModel> getOrders(LocalDate date){
        ArrayList<OrderModel> orders = new ArrayList<OrderModel>();
        for (OrderModel order : OrderManager.orderModelArrayList){
            if(order.getCreateDate().isEqual(date)){
                orders.add(order);
            }
        }
        return orders;
    }
}
