package com.theeditorstudio.ordermanager.menus;

import com.theeditorstudio.ordermanager.actions.menu.AboutAction;
import com.theeditorstudio.ordermanager.interfaces.IMenu;

import javax.swing.*;
import java.awt.event.KeyEvent;

/**
 * Help Menu Factory
 */
public class HelpMenu extends JMenu implements IMenu {
    JMenu menu = new JMenu("Help");

    JMenuItem about;

    /**
     * Construct Help Menu
     */
    public HelpMenu(){
        // Construct menu item
        about = new JMenuItem("About");
        about.addActionListener(new AboutAction());
        about.setMnemonic(KeyEvent.VK_A);
        // Set menu layout
        menu.add(about);
        menu.setMnemonic(KeyEvent.VK_H);
    }

    /**
     * Get the constructed menu
     * @return JMenu
     */
    @Override
    public JMenu getMenu() {
        return menu;
    }
}
