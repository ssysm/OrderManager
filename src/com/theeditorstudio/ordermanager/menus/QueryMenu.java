package com.theeditorstudio.ordermanager.menus;

import com.theeditorstudio.ordermanager.actions.menu.QueryOrdersByDateAction;
import com.theeditorstudio.ordermanager.actions.menu.QueryOrdersByNameAction;
import com.theeditorstudio.ordermanager.interfaces.IMenu;

import javax.swing.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class QueryMenu extends JMenu implements IMenu {
    JMenu menu = new JMenu("Query");

    JMenuItem date_query,name_query;

    public QueryMenu(){
        date_query = new JMenuItem("Query by Date");
        date_query.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, InputEvent.CTRL_DOWN_MASK));
        date_query.addActionListener(new QueryOrdersByDateAction());
        date_query.setMnemonic(KeyEvent.VK_D);

        name_query = new JMenuItem("Query by Client Name");
        name_query.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_DOWN_MASK));
        name_query.addActionListener(new QueryOrdersByNameAction());
        name_query.setMnemonic(KeyEvent.VK_C);

        menu.add(date_query);
        menu.add(name_query);
        menu.setMnemonic(KeyEvent.VK_R);
    }

    @Override
    public JMenu getMenu() {
        return menu;
    }

}
