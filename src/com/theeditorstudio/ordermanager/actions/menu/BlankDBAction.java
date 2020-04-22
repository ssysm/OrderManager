package com.theeditorstudio.ordermanager.actions.menu;

import com.theeditorstudio.ordermanager.OrderManager;
import com.theeditorstudio.ordermanager.models.OrderModel;
import com.theeditorstudio.ordermanager.models.OrderTableModel;
import com.theeditorstudio.ordermanager.windows.components.StatusComponent;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static com.theeditorstudio.ordermanager.adapters.MainWindowAdapter.ObjButtons;

/**
 * Create New Blank Database Event Action
 *
 * This action listen will fire after the user press the
 * 'New Blank DB' Button
 */
public class BlankDBAction implements ActionListener {

    /**
     * Button press trigger
     * @param e Action Event
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        // Check if modified flag is set
        if(OrderManager.isModified){
            int PromptResult = JOptionPane.showOptionDialog(OrderManager.frame,
                    "You have modified data that's unsaved.\nAre you sure you want to create a blank DB?",
                    "Order Manager", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
                    null, ObjButtons, ObjButtons[1]);
            if (PromptResult == JOptionPane.NO_OPTION) {
                return;
            }
        }
        OrderManager.orderModelArrayList = new ArrayList<OrderModel>();
        OrderManager.table.setModel(new OrderTableModel());
        OrderManager.isModified = false;
        StatusComponent.updateStatus();
    }
}
