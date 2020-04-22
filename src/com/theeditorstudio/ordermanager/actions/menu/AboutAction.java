package com.theeditorstudio.ordermanager.actions.menu;

import com.theeditorstudio.ordermanager.windows.dialogs.AboutDialog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * About Button Event Action
 *
 * This action listen will fire after the user press the
 * 'About' Button
 */
public class AboutAction implements ActionListener {

    /**
     * Button press trigger
     * @param e Action Event
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        new AboutDialog();
    }
}
