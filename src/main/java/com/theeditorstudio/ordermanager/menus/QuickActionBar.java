package com.theeditorstudio.ordermanager.menus;

import com.theeditorstudio.ordermanager.actions.menu.NewOrderAction;
import com.theeditorstudio.ordermanager.actions.menu.OpenFileAction;
import com.theeditorstudio.ordermanager.actions.table.OrderIDLookupAction;

import javax.swing.*;

/**
 * Quick Action Bar Factory
 */
public class QuickActionBar extends JPanel{
    JPanel panel;
    JToolBar toolBar;
    JButton addOrder;
    public static JTextField orderID;

    /**
     * Construct Toolbar
     */
    public QuickActionBar(){
        // Construct bar item
        panel = new JPanel();
        toolBar = new JToolBar();
        addOrder = new JButton("Add Order");
        orderID = new JTextField(10);
        // set swing options
        orderID.setToolTipText("Order ID Lookup");
        orderID.setText("Order ID");
        orderID.addKeyListener(new OrderIDLookupAction());
        addOrder.addActionListener(new NewOrderAction());
        // set layout
        panel.add(addOrder);
        panel.add(new JLabel("Order ID Search:"));
        panel.add(orderID);
        toolBar.add(panel);
        toolBar.setFloatable(false);
    }

    /**
     * Get the constructed tool bar
     * @return JPanel
     */
    public JPanel getToolBar() {
        return panel;
    }
}
