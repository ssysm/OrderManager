package com.theeditorstudio.ordermanager.actions.table;

import com.theeditorstudio.ordermanager.OrderManager;
import com.theeditorstudio.ordermanager.models.OrderTableModel;
import com.theeditorstudio.ordermanager.windows.components.StatusComponent;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.JOptionPane.showMessageDialog;

/**
 * Delete Order Right CTX Menu Event Action
 *
 * This action listen will fire after the user press the
 * 'Delete' Button from the right click ctx from the table
 */
public class DeleteOrderAction implements ActionListener {

    /**
     * Button press trigger
     * @param e Action Event
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        int row = OrderManager.table.getSelectedRow();
        row = OrderManager.table.convertRowIndexToModel(row); // Follow UI Sort
        if(row > OrderManager.orderModelArrayList.size() || row == -1){
            showMessageDialog(OrderManager.frame,"Incorrect Row Selected", "Error", JOptionPane.ERROR_MESSAGE);
            return ;
        }
        // Remove from ArrayList then reset the table model
        OrderManager.orderModelArrayList.remove(row);
        OrderManager.table.setModel(new OrderTableModel(OrderManager.orderModelArrayList));
        showMessageDialog(OrderManager.frame,"Removed Row at " + (row + 1), "Info", JOptionPane.INFORMATION_MESSAGE);
        // !!!SET GLOBAL STATUS FLAG!!!
        OrderManager.isModified = true;
        StatusComponent.updateStatus();
    }
}
