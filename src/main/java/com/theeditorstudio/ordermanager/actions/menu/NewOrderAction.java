package com.theeditorstudio.ordermanager.actions.menu;

import com.theeditorstudio.ordermanager.OrderManager;
import com.theeditorstudio.ordermanager.windows.dialogs.OrderCreateDialog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Create New Order Event Action
 *
 * This action listen will fire after the user press the
 * 'New Order' Button from the toolbar.
 */
public class NewOrderAction implements ActionListener {

    /**
     * Button press trigger
     * @param e Action Event
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        OrderCreateDialog orderCreate = new OrderCreateDialog();
        orderCreate.pack();
        orderCreate.setLocationRelativeTo(OrderManager.frame);
        orderCreate.setVisible(true);
    }
}
