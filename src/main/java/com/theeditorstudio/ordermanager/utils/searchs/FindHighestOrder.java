package com.theeditorstudio.ordermanager.utils.searchs;

import com.theeditorstudio.ordermanager.OrderManager;
import com.theeditorstudio.ordermanager.models.OrderModel;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * Find highest order and return the value of the order
 */
public class FindHighestOrder {
    public static OrderModel getOrder(){
        ArrayList<OrderModel> models = OrderManager.orderModelArrayList;
        models.sort(Comparator.comparingDouble(OrderModel::getItemTotal));
        return models.get(0);
    }
}
