package com.theeditorstudio.ordermanager.actions.menu;

import com.theeditorstudio.ordermanager.OrderManager;
import com.theeditorstudio.ordermanager.windows.dialogs.searchs.SearchOrderByDateDialog;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Query Order Event Action
 *
 * This action listen will fire after the user press the
 * 'Query Client Orders' Button from the toolbar.
 */
public class QueryOrdersByDateAction implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        JDialog dialog = new SearchOrderByDateDialog();
        dialog.pack();
        dialog.setLocationRelativeTo(OrderManager.frame);
        dialog.setVisible(true);
    }
}
