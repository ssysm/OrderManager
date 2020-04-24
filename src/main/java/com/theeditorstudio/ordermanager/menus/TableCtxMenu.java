package com.theeditorstudio.ordermanager.menus;

import com.theeditorstudio.ordermanager.actions.table.DeleteOrderAction;
import com.theeditorstudio.ordermanager.actions.table.OrderDetailAction;

import javax.swing.*;

/**
 * Table Content Menu Factory
 */
public class TableCtxMenu {
    final JPopupMenu popupMenu  = new JPopupMenu();
    final JMenuItem deleteItem = new JMenuItem("Delete");
    final JMenuItem itemDetail = new JMenuItem("Detail");

    /**
     * Construct Table Ctx Bar
     */
    public TableCtxMenu(){
        deleteItem.addActionListener(new DeleteOrderAction());
        itemDetail.addActionListener(new OrderDetailAction());
        popupMenu.add(itemDetail);
        popupMenu.addSeparator();
        popupMenu.add(deleteItem);
    }

    /**
     * Get the constructed table ctx bar
     * @return JPopupMenu
     */
    public JPopupMenu getPopupMenu() {
        return popupMenu;
    }
}
