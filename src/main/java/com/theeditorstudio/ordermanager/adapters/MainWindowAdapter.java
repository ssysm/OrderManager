package com.theeditorstudio.ordermanager.adapters;

import com.theeditorstudio.ordermanager.OrderManager;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Main Window Event Adapter
 *
 * This Inherit the Swing WindowAdapter and impl
 * a warning message that will warn user is any
 * file in the workspace that's not been saved
*/
public class MainWindowAdapter extends WindowAdapter {

    public static String[] ObjButtons = {"Yes","No"};

    /**
     * Inherit from WindowAdapter,
     * warn user about the unsaved data by
     * check flag from the OrderManager Global var
     * @param e Window Event
     */
    @Override
    public void windowClosing(WindowEvent e) {
        if(OrderManager.isModified) {
            int PromptResult = JOptionPane.showOptionDialog(OrderManager.frame,
                    "You have modified data that's unsaved.\nAre you sure you want to exit?",
                    "Order Manager", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
                    null, ObjButtons, ObjButtons[1]);
            if (PromptResult == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        }else{
            System.exit(0);
        }
    }
}
