package com.theeditorstudio.ordermanager.windows.components;

import com.theeditorstudio.ordermanager.OrderManager;
import com.theeditorstudio.ordermanager.utils.CalculateOrderPrice;

import java.util.HashMap;

/**
 * Update Footer Status Message
 */
public class StatusComponent {
    public static void updateStatus(){
        HashMap<Character,String> hashMap = CalculateOrderPrice.getCalculation();
        OrderManager.status.setText("Total Orders: " + hashMap.get('s') +
                                    ". Average Order Price: $" + hashMap.get('a') +
                                    ". Orders Total: $" + hashMap.get('t') + '.');
    }
}
