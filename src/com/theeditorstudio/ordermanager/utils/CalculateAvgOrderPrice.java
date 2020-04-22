package com.theeditorstudio.ordermanager.utils;

import com.theeditorstudio.ordermanager.OrderManager;
import com.theeditorstudio.ordermanager.models.OrderModel;

/**
 * Calculate Avg Order Price
 */
public class CalculateAvgOrderPrice {

    /**
     * Get Avg Order Price
     */
    public static String getCalculation(){
        double total = 0.0;
        int orderSize = OrderManager.orderModelArrayList.size();
        for (OrderModel order: OrderManager.orderModelArrayList) {
            total += order.getItemTotal();
        }
        return "Average Order Price: " + String.format("%.2f",(total / orderSize));
    }
}
