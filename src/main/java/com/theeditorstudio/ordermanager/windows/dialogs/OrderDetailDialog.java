package com.theeditorstudio.ordermanager.windows.dialogs;

import com.theeditorstudio.ordermanager.OrderManager;
import com.theeditorstudio.ordermanager.models.OrderModel;

import javax.swing.*;
import java.awt.*;

public class OrderDetailDialog {
    JDialog detailDialog;
    JLabel label;
    OrderModel order;

    public OrderDetailDialog(OrderModel order){
        this.order = order;
        detailDialog = new JDialog(OrderManager.frame, "Order Detail - ID:" + order.getOrderID());
        label = new JLabel(orderLabelBuilder(order));
        detailDialog.add(label);
        detailDialog.setSize(320,240);
        detailDialog.setMinimumSize(new Dimension(320,240));
        detailDialog.setMaximumSize(new Dimension(320,240));
        detailDialog.setVisible(true);
        detailDialog.setLocationRelativeTo(OrderManager.frame);
    }

    private static String orderLabelBuilder(OrderModel order){
        return "<html>" +
               "<h3>Order ID:" +
               order.getOrderID() +
               "</h3>(Placed on:" +
               order.getCreateDate() +
               ", Shipping EST:" +
               order.getESTShipping() +
               ")<br/><span>Client First Name: <b>" +
               order.getFirstName() +
               "</b></span><br/><span>Client Last Name: <b>" +
               order.getLastName() +
               "</b></span><br/><span>Item Name: <b>" +
               order.getItemName() +
               "</b></span><br/><span>Item Price: <b>" +
               order.getItemPrice() +
               "</b></span><br/><span>Item Quantity: <b>" +
               order.getQuantity() +
               "</b></span><br/><span>Order Total: <b>" +
               order.getItemTotal() +
               "</b></span><html>";
    }
}
