package com.theeditorstudio.ordermanager.utils;

import com.theeditorstudio.ordermanager.OrderManager;
import com.theeditorstudio.ordermanager.models.OrderModel;

import java.util.HashMap;

/**
 * Calculate Various Order Price
 */
public class CalculateOrderPrice {

    /**
     * Get Avg Order Price
     * Hash map key meaning:
     * s: Size of the order
     * a: order average
     * t: order total
     */
    public static HashMap<Character,String> getCalculation(){
        HashMap<Character, String> hashMap = new HashMap<>();
        double total = 0.0;
        int orderSize = OrderManager.orderModelArrayList.size();
        hashMap.put('s',String.valueOf(orderSize));
        for (OrderModel order: OrderManager.orderModelArrayList) {
            total += order.getItemTotal();
        }
        hashMap.put('a', String.format("%.2f",(total / orderSize)));
        hashMap.put('t', String.format("%.2f", total));
        return hashMap;
    }
}
