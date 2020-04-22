package com.theeditorstudio.ordermanager.actions.menu;

import com.theeditorstudio.ordermanager.adapters.MainWindowAdapter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Quit Event Action
 *
 * This action listen will fire after the user press the
 * 'Quit' Button from menu.
 */
public class QuitAction implements ActionListener {

    /**
     * Button press trigger
     * @param e Action Event
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        MainWindowAdapter windowAdapter = new MainWindowAdapter(); // Manually Fire the window closing event
        windowAdapter.windowClosing(null);
    }
}
