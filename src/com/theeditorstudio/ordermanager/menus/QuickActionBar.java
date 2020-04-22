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
    JButton addOrder, openDB;
    public static JTextField orderID;

    /**
     * Construct Toolbar
     */
    public QuickActionBar(){
        // Construct bar item
        panel = new JPanel();
        toolBar = new JToolBar();
        addOrder = new JButton("Add Order");
        openDB = new JButton("Open Database");
        orderID = new JTextField(10);
        // set swing options
        orderID.setToolTipText("Order ID Lookup");
        orderID.setText("Order ID");
        orderID.addKeyListener(new OrderIDLookupAction());
        openDB.addActionListener(new OpenFileAction());
        addOrder.addActionListener(new NewOrderAction());
        // set layout
        panel.add(openDB);
        panel.add(addOrder);
        panel.add(new JLabel("ID Search:"));
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
