package com.theeditorstudio.ordermanager.menus;

import javax.swing.*;

/**
 * Menu Bar Factory
 */
public class MenuBarFactory {
    JMenuBar jMenuBar;

    /**
     * Construct Menu Bar
     */
    public MenuBarFactory(){
        jMenuBar = new JMenuBar();
        jMenuBar.add(new FileMenu().getMenu());
        jMenuBar.add(new QueryMenu().getMenu());
        jMenuBar.add(new HelpMenu().getMenu());
    }

    /**
     * Get the constructed menu bar
     * @return JMenuBar
     */
    public JMenuBar getMenuBar(){
        return jMenuBar;
    }

}
