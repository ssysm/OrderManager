package com.theeditorstudio.ordermanager.actions.table;

import com.theeditorstudio.ordermanager.OrderManager;
import com.theeditorstudio.ordermanager.windows.dialogs.OrderDetailDialog;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.JOptionPane.showMessageDialog;

public class OrderDetailAction implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        int row = OrderManager.table.getSelectedRow();
        row = OrderManager.table.convertRowIndexToModel(row); // Follow UI Sort
        if(row > OrderManager.orderModelArrayList.size() || row == -1){
            showMessageDialog(OrderManager.frame,"Incorrect Row Selected", "Error", JOptionPane.ERROR_MESSAGE);
            return ;
        }
        new OrderDetailDialog(OrderManager.orderModelArrayList.get(row));
    }
}
