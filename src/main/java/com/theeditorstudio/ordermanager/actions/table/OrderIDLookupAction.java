package com.theeditorstudio.ordermanager.actions.table;

import com.theeditorstudio.ordermanager.OrderManager;
import com.theeditorstudio.ordermanager.menus.QuickActionBar;
import com.theeditorstudio.ordermanager.models.OrderModel;
import com.theeditorstudio.ordermanager.windows.dialogs.OrderDetailDialog;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static javax.swing.JOptionPane.showMessageDialog;

public class OrderIDLookupAction implements KeyListener {
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_ENTER){
            OrderModel order = OrderManager.orderModelArrayList.stream()
                    .filter(orderModel-> QuickActionBar.orderID.getText().equals(orderModel.getOrderID()))
                    .findFirst()
                    .orElse(null);
            if(order != null){
                new OrderDetailDialog(order);
            }else{
                showMessageDialog(OrderManager.frame, "Input Error:\n Cannot Find Order ", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
