package com.theeditorstudio.ordermanager.windows.components;

import com.theeditorstudio.ordermanager.OrderManager;
import com.theeditorstudio.ordermanager.utils.CalculateAvgOrderPrice;

public class StatusComponent {

    //TODO: impl dyn change
    private static String avgPrice = "0.00";

    public static void updateStatus(){
        OrderManager.status.setText(CalculateAvgOrderPrice.getCalculation());
    }

}
